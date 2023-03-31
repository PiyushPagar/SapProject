package com.SapPortal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.FeesStructure;
import com.SapPortal.models.ModulesName;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.FeesStructureRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FeesStructureController {
	
	@Autowired
	FeesStructureRepository feesStructureRepository;
	
	
	@RequestMapping(value = "/addnewfees", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addNewFeesstructure(@RequestBody FeesStructure feesStructure) {
		FeesStructure feesStructureexist =feesStructureRepository.findBystudentType(feesStructure.getStudentType());
		if(feesStructureexist != null) {
			feesStructureexist.setTotalFees(feesStructure.getTotalFees());
			feesStructureRepository.save(feesStructureexist);
		}else {
			feesStructureRepository.save(feesStructure);
		}
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"new fees added successfully!"));	
	}
	
	@RequestMapping(value = "/getallfeesstructure", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<FeesStructure>> getFeesStructure(@RequestParam String status) {
		List<FeesStructure> modulesNameList =feesStructureRepository.findAllByStatus(status);
		return ResponseEntity.ok(modulesNameList);	
	}

}
