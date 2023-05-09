package com.SapPortal.controllers;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.dto.AdminUserDto;
import com.SapPortal.models.AdminDetails;
import com.SapPortal.models.ERole;
import com.SapPortal.models.Role;
import com.SapPortal.models.User;
import com.SapPortal.payload.request.SignupRequestAdmin;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.AdminDetailsRepository;
import com.SapPortal.repository.RoleRepository;
import com.SapPortal.repository.UserRepository;
import com.SapPortal.security.jwt.JwtUtils;
import com.SapPortal.security.services.AdminService;
import com.SapPortal.security.services.EmailSenderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/auth")
public class AdminController {

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
	@Autowired
	AdminDetailsRepository adminDetailsRepository;
	@Autowired
	AdminService adminService;

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestAdmin signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse(HttpStatus.BAD_REQUEST.value(), "Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getMobileNumber(),
				signUpRequest.getStatus());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ADMIN":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "SUPERADMIN":
					Role modRole = roleRepository.findByName(ERole.ROLE_SUPERADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		Long userId = userRepository.save(user).getId();
		AdminDetails adminDetails = new AdminDetails(signUpRequest.getDepartment(), signUpRequest.getPosition(),
				userId);
		adminDetailsRepository.save(adminDetails);

		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), "User registered successfully!"));
	}

	@GetMapping("/getAllAdminUsers/{status}")
	private List<AdminUserDto> getAllAdminUsers(@RequestParam(name = "status") String status) {

		return adminService.getAllAdminUser(status);
	}

	@GetMapping("/getAdminUsers/{status}")
	private AdminDetails getAdminUsers(@RequestParam(name = "id") Integer userId) {
		Long useriddd = new Long(userId);
		AdminDetails adminDetails = adminDetailsRepository.findByUserId(useriddd).get();
		return adminDetails;
	}

	@GetMapping("/deleteAdminUsers")
	private MessageResponse deleteAdminUsers(@RequestParam(name = "UserId") Integer UserIdl) {
		@SuppressWarnings("deprecation")
		Long userid = new Long(UserIdl);
		return adminService.deleteAdminUser(userid);
	}

	@PostMapping("/updateAdminUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestAdmin signUpRequest,
			@RequestParam(name = "UserId") Integer UserIdl) {
		@SuppressWarnings("deprecation")
		Long UserId = new Long(UserIdl);
		User users = userRepository.findById(UserId).get();
		AdminDetails adminDetails = adminDetailsRepository.findByUserId(UserId).get();
		if (users != null && adminDetails != null) {
			users.setEmail(signUpRequest.getEmail());
			users.setMobileNumber(signUpRequest.getMobileNumber());
			users.setName(signUpRequest.getName());
			userRepository.save(users);
			adminDetails.setDepartment(signUpRequest.getDepartment());
			adminDetails.setPosition(signUpRequest.getPosition());
			adminDetailsRepository.save(adminDetails);

		}
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), "User registered successfully!"));
	}

}
