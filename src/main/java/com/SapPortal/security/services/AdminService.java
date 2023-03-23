package com.SapPortal.security.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SapPortal.dto.AdminUserDto;
import com.SapPortal.models.User;
import com.SapPortal.payload.request.SignupRequestAdmin;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.AdminDetailsRepository;
import com.SapPortal.repository.CustomRepository;
import com.SapPortal.repository.UserRepository;
import com.SapPortal.util.ConstantUtil;

@Service
public class AdminService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CustomRepository customRepository;
	@Autowired
	AdminDetailsRepository adminDetailsRepository;
	
	
	public List<AdminUserDto> getAllAdminUser(String status) {
		List<AdminUserDto> adminUserDtoList= userRepository.findAllAdminUser(status);
		return adminUserDtoList;
	}


	public MessageResponse deleteAdminUser(Long userId) {
		MessageResponse messageResponse = null;
		User user = userRepository.findById(userId).get();
		if(user==null) {
			messageResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			messageResponse.setMessage("User not found or not delete");
		}
		user.setStatus(ConstantUtil.Inactive);
		userRepository.save(user);
		messageResponse.setStatus(HttpStatus.ACCEPTED.value());
		messageResponse.setMessage("User is deleted successfully");
		return messageResponse;
	}


	
	

}
