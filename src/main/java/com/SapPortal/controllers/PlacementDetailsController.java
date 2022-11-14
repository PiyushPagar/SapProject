package com.SapPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.SapPortal.repository.PlacementDetailsRepository;
import com.SapPortal.security.services.FileService;

@RestController
public class PlacementDetailsController {
	
	@Autowired
	PlacementDetailsRepository placementDetailsRepository;
	@Autowired
	FileService fileService;

	

}
