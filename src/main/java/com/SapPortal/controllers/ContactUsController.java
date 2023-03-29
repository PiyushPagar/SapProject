package com.SapPortal.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.ApplicationForm;
import com.SapPortal.models.ContactUs;
import com.SapPortal.payload.request.LoginRequest;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.payload.response.UserInfoResponse;
import com.SapPortal.repository.ContactUsRepository;
import com.SapPortal.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ContactUsController {
	
	@Autowired
	ContactUsRepository contactUsRepository;

	
	
	@PostMapping("/postcontactus")
	public ResponseEntity<?> authenticateUser( @RequestBody ContactUs contactUs) {
		contactUsRepository.save(contactUs);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"form submitted sucessfully!"));
	}
	
	
	@GetMapping("/getcontactus")
	private List<ContactUs> getAllcontactus() {
		return contactUsRepository.findAllByOrderByIdAsc();
	}
}
