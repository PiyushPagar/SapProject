package com.SapPortal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.dto.Response;
import com.SapPortal.models.PlacementDetails;
import com.SapPortal.models.Status;
import com.SapPortal.repository.PlacementDetailsRepository;
import com.SapPortal.security.services.FileService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PlacementDetailsController {

	@Autowired
	PlacementDetailsRepository placementDetailsRepository;
	@Autowired
	FileService fileService;

	@SuppressWarnings("rawtypes")
	@GetMapping("/getAllPlacement")
	public List getAllPlacement() {
		List<PlacementDetails> getAllPlacement = placementDetailsRepository.findAll();
		return getAllPlacement;
	}

	@RequestMapping(value = "/addNewPlacement", method = RequestMethod.POST)
	@ResponseBody
	public Response updateAlertReadStatus(@RequestBody PlacementDetails placementDetails, HttpServletRequest request) {
		Response response=new Response();
		PlacementDetails placementDetailsinfo=new PlacementDetails();
		try {
		placementDetailsinfo.setName(placementDetails.getName());
		placementDetailsinfo.setCompanyname(placementDetails.getCompanyname());
		placementDetailsinfo.setImageUrl(placementDetails.getImageUrl());
		placementDetailsinfo.setModule(placementDetails.getModule());
		placementDetailsinfo.setPlacementYear(placementDetails.getPlacementYear());
		placementDetailsinfo.setPlacementpackage(placementDetails.getPlacementpackage());
		placementDetailsRepository.save(placementDetailsinfo);
		response.setMessage("Placement added sucessful");
    	response.setStatus(Status.SUCCESS);
		}catch(Exception e) {
			response.setMessage("Placement not added"+e.getMessage());
	    	response.setStatus(Status.FAILED);
			
		}
		
		return response;
	}

}
