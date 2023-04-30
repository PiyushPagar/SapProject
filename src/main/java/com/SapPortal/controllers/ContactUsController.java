package com.SapPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.ContactUs;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.ContactUsRepository;

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
