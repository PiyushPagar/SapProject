package com.SapPortal.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.ERole;
import com.SapPortal.models.Role;
import com.SapPortal.models.User;
import com.SapPortal.payload.request.Forgotpassword;
import com.SapPortal.payload.request.LoginRequest;
import com.SapPortal.payload.request.SignupRequest;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.payload.response.UserInfoResponse;
import com.SapPortal.repository.RoleRepository;
import com.SapPortal.repository.UserRepository;
import com.SapPortal.security.jwt.JwtUtils;
import com.SapPortal.security.services.EmailSenderService;
import com.SapPortal.security.services.UserDetailsImpl;
import com.SapPortal.util.ConstantUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(
				new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(),jwtCookie.getValue(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse(HttpStatus.BAD_REQUEST.value(),"Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getMobileNumber(),signUpRequest.getStatus());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "STUDENT":
					Role stuRole = roleRepository.findByName(ERole.ROLE_STUDENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(stuRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"User registered successfully!"));
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse(HttpStatus.OK.value(),"You've been signed out!"));
	}
	
	@PostMapping("/forgotpassword/{Email}")
	public ResponseEntity<?> forgotpassword(@PathVariable("Email") String email) {
		String response= emailSenderService.sendEmail(email,ConstantUtil.OtpverificationSubject,ConstantUtil.OtpverificationBody);
		return ResponseEntity.ok().body(new MessageResponse(HttpStatus.OK.value(),response));  
    }
	
	
	@PostMapping("/forgotpassword/setnewpassword")
	public ResponseEntity<?> forgotpassword(@RequestBody Forgotpassword forgotpassword) {
		String password= encoder.encode(forgotpassword.getPassword());
		userRepository.updatepasswordwithemail(forgotpassword.getEmail(),password);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"new password set sucessfully"));

    }
	
}