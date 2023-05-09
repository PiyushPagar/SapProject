package com.SapPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.FeesStructure;
import com.SapPortal.models.SapCredentialsDatails;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.SapCredentialsDatailsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SapCredentialsDatailsController {
	
	@Autowired
	SapCredentialsDatailsRepository sapCredentialsDatailsRepository;
	
	@PostMapping("/postsapcredentialsDetails")
	public ResponseEntity<?> authenticateUser( @RequestBody SapCredentialsDatails sapCredentialsDatails) {
		sapCredentialsDatailsRepository.save(sapCredentialsDatails);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"Sap Credentials Datails submitted sucessfully!"));
	}
	
	
	@RequestMapping(value = "/getsapcredentialsDetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getFeesStructure(@RequestParam Integer userIds) {
		@SuppressWarnings("deprecation")
		Long userId =new Long(userIds);
		SapCredentialsDatails sapCredentialsDatails =sapCredentialsDatailsRepository.findByUserId(userId);
		return ResponseEntity.ok(sapCredentialsDatails);	
	}

}
