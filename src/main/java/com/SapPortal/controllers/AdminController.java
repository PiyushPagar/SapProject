package com.SapPortal.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
			return ResponseEntity.badRequest().body(new MessageResponse(HttpStatus.BAD_REQUEST.value(),"Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getMobileNumber(),signUpRequest.getStatus());
		
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
		Long userId=userRepository.save(user).getId();
		AdminDetails adminDetails =new AdminDetails(signUpRequest.getDepartment(),signUpRequest.getPosition(),userId);
		adminDetailsRepository.save(adminDetails);
		
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"User registered successfully!"));
	}
	
	
	
	
	@GetMapping("/getAdminUsers/{status}")
	private List<AdminUserDto> getAllAdminUsers(@RequestParam(name = "status") String status) {
		
		return adminService.getAllAdminUser(status);
	}
	
	@GetMapping("/deleteAdminUsers")
	private MessageResponse getAllAdminUsers(@RequestParam(name = "UserId") Long UserId) {
		
		return adminService.deleteAdminUser(UserId);
	}

	@PostMapping("/updateAdminUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestAdmin signUpRequest,@RequestParam(name = "UserId") Long UserId) {
		 User users=userRepository.findById(UserId).get();
		 AdminDetails adminDetails =adminDetailsRepository.findByUserId(UserId).get();
	     if(users!=null && adminDetails!=null){
	    	 users.setEmail(signUpRequest.getEmail());
	    	 users.setMobileNumber(signUpRequest.getMobileNumber());
	    	 users.setName(signUpRequest.getName());
	    	 userRepository.save(users);
	    	 adminDetails.setDepartment(signUpRequest.getDepartment());
	    	 adminDetails.setPosition(signUpRequest.getPosition());
	 		 adminDetailsRepository.save(adminDetails);

	     }
		 return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"User registered successfully!"));
	}
	
//	@RequestMapping(value = "/fetchlistofApplicationFormbyfilter", method = RequestMethod.GET)
//	public ResponseEntity<PagesDto<ApplicationForm>> fetchproductsByCategory(
//			@RequestParam(value = "pagenum", required = false) Integer pagenum,
//			@RequestParam(value = "pagesize", required = false) Integer pagesize,
//			@RequestParam(value = "email", required = false) String email,
//			@RequestParam(value = "StudentId", required = false) Integer StudentId,
//			@RequestParam(value = "name", required = false) String name,
//			@RequestParam(value = "collegeEmail", required = false) String collegeEmail,
//			@RequestParam(value = "sapModule", required = false) String sapModule,
//			@RequestParam(value = "contactNumber", required = false) String contactNumber,
//			@RequestParam(value = "passoutYear", required = false) String passoutYear,
//			@RequestParam(value = "branch", required = false) String branch,
//			@RequestParam(value = "specialization", required = false) String specialization,
//			@RequestParam(value = "studentType", required = false) String studentType,
//			@RequestParam(value = "adhaarCard", required = false) String adhaarCard,
//			@RequestParam(value = "uploadImage", required = false) Boolean uploadImage,
//			@RequestParam(value = "applicationFromStatus", required = false) String applicationFromStatus,
//			@RequestParam(value = "userId", required = false) Long user_id, HttpServletRequest request) {
//		PagesDto<ApplicationForm> pages = applicationFromService.listOfApplicationFormFilter(pagenum, pagesize, email,
//				StudentId, name, collegeEmail, sapModule, contactNumber, passoutYear, branch, specialization,
//				studentType, adhaarCard, uploadImage, applicationFromStatus, user_id);
//		return new ResponseEntity<>(pages, HttpStatus.OK);
//	}

	
	
	
	

}
