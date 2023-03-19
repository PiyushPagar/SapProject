package com.SapPortal.controllers;

import java.util.*;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.dto.Response;
import com.SapPortal.models.ApplicationForm;
import com.SapPortal.models.ApplicationQueryByAdmin;
import com.SapPortal.models.PlacementDetails;
import com.SapPortal.models.Status;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.repository.ApplicationQueryByAdminRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/applicationFrom")
public class ApplicationQueryByAdminController {
	
	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	@Autowired
	ApplicationQueryByAdminRepository applicationQueryByAdminRepository;
	
	@GetMapping("/getapplicationformbyapplicationId/{ApplicationId}")
	private ApplicationQueryByAdmin getApplicationForm(@PathVariable("ApplicationId") int applicationId) {
		ApplicationQueryByAdmin applicationQueryByAdmin = applicationQueryByAdminRepository.findByApplicationIdAndIsActive(applicationId,"active");
		return applicationQueryByAdmin;
	}
	
	@RequestMapping(value = "/postapplicationformbyapplicationId/{ApplicationId}", method = RequestMethod.POST)
	@ResponseBody
	public Response updateAlertReadStatus(@PathVariable("ApplicationId") int applicationId ,@RequestBody ApplicationQueryByAdmin applicationQueryByAdmin, HttpServletRequest request) {
		Response response=new Response();
		List<ApplicationQueryByAdmin> oldApplicationQueryByAdminobj=applicationQueryByAdminRepository.findAllByApplicationIdAndIsActive(applicationId,"active");
		if(oldApplicationQueryByAdminobj.size()>0) {
			for(ApplicationQueryByAdmin appli:oldApplicationQueryByAdminobj) {
				appli.setIsActive("inactive");
				applicationQueryByAdminRepository.save(appli);
			}
		}
		ApplicationQueryByAdmin applicationQueryByAdminobj=new ApplicationQueryByAdmin();
		ApplicationForm applicationForm=applicationFormRepository.findById(applicationId).get();
		try {
			applicationForm.setIsQueryInApplication(true);
			applicationFormRepository.save(applicationForm);
			applicationQueryByAdminobj.setApplicationId(applicationId);
			applicationQueryByAdminobj.setContactDetails(applicationQueryByAdmin.getContactDetails());
			applicationQueryByAdminobj.setQueryDesc(applicationQueryByAdmin.getQueryDesc());
			applicationQueryByAdminobj.setQueryTitle(applicationQueryByAdmin.getQueryTitle());
			applicationQueryByAdminobj.setReachoutPersonContactNumber(applicationQueryByAdmin.getReachoutPersonContactNumber());
			applicationQueryByAdminobj.setReachoutPersonDetails(applicationQueryByAdmin.getReachoutPersonDetails());
			applicationQueryByAdminobj.setReachoutPersonName(applicationQueryByAdmin.getReachoutPersonName());
			applicationQueryByAdminobj.setUserId(applicationQueryByAdmin.getUserId());
			applicationQueryByAdminobj.setIsActive("active");
		applicationQueryByAdminRepository.save(applicationQueryByAdminobj);
		response.setMessage("Placement added sucessful");
    	response.setStatus(Status.SUCCESS);
		}catch(Exception e) {
			response.setMessage("Placement not added"+e.getMessage());
	    	response.setStatus(Status.FAILED);
		}
		return response;
	}
	
	

	
}