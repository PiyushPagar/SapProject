package com.SapPortal.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.ApplicationForm;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.security.services.ApplicationFromService;

@RestController
@RequestMapping("/api")
public class ApplicationFromController {
	@Autowired
	ApplicationFormRepository applicationFormRepository;
  
	@Autowired
	ApplicationFromService applicationFromService;
	 @RequestMapping(value = "/getDetailsByUserid/{UserId}", method = RequestMethod.GET)
	    @ResponseBody
	    public List<ApplicationForm> getOtasbyClient(@RequestParam(name = "UserId") Integer UserId) {
	    	List<ApplicationForm> otas = Collections.emptyList();
	    	otas = applicationFormRepository.findByUseridLike(UserId);
	        return otas;
	    }
	@GetMapping("/getapplicationform")
	private List<ApplicationForm> getAllApplicationForm() {
		return applicationFromService.getAllApplicationForm();
	}

	@GetMapping("/getapplicationformbyid/{StudentId}")
	private ApplicationForm getApplicationForm(@PathVariable("StudentId") int StudentId) {
		return applicationFromService.getApplicationFormById(StudentId);
	}

	@DeleteMapping("/deleteapplicationform/{StudentId}")
	private void deleteBook(@PathVariable("StudentId") int StudentId) {
		applicationFromService.delete(StudentId);
	}

	@PostMapping("/applicationForm")
	private int saveBook(@RequestBody ApplicationForm applicationForm) {
		applicationFromService.saveOrUpdate(applicationForm);
		return applicationForm.getStudentId();
	}

	@PutMapping("/applicationFormupdate")
	private ApplicationForm update(@RequestBody ApplicationForm applicationForm) {
		applicationFromService.saveOrUpdate(applicationForm);
		return applicationForm;
	}
}