package com.SapPortal.controllers;

import java.util.Collections;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.SapPortal.dto.PagesDto;
import com.SapPortal.models.ApplicationForm;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.security.services.ApplicationFromService;

@CrossOrigin(origins = "*", maxAge = 3600)
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
	
	@RequestMapping(value="/fetchlistofApplicationFormbyfilter",method = RequestMethod.GET)
    public ResponseEntity<PagesDto<ApplicationForm>> fetchproductsByCategory(@RequestParam(value = "pagenum", required = false) Integer pagenum,
			@RequestParam(value = "pagesize", required = false) Integer pagesize,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "StudentId", required = false) Integer StudentId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "collegeEmail", required = false) String collegeEmail,
			@RequestParam(value = "sapModule", required = false) String sapModule,
			@RequestParam(value = "contactNumber", required = false) String contactNumber,
			@RequestParam(value = "passoutYear", required = false) String passoutYear,
			@RequestParam(value = "branch", required = false) String branch,
			@RequestParam(value = "specialization", required = false) String specialization,
			@RequestParam(value = "studentType", required = false) String studentType,
			@RequestParam(value = "adhaarCard", required = false) String adhaarCard,
			@RequestParam(value = "uploadImage", required = false) Boolean uploadImage,
			@RequestParam(value = "applicationFromStatus", required = false) String applicationFromStatus,
			@RequestParam(value = "userId", required = false) Long user_id,
			HttpServletRequest request){
    	    PagesDto<ApplicationForm> pages=   applicationFromService.listOfApplicationFormFilter(pagenum,pagesize, email, StudentId,  name, collegeEmail,sapModule, contactNumber,
    	    		passoutYear, branch, specialization, studentType,adhaarCard,uploadImage,applicationFromStatus,user_id);
    	     return new ResponseEntity<>(pages,HttpStatus.OK);
    }
	
	
}