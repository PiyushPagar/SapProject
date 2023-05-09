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
import com.SapPortal.models.ModulesName;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.ModulesNameRepository;

@CrossOrigin(origins = "*", maxAge = 3600)@RestController
public class ModulesNameController {
	
	@Autowired
	ModulesNameRepository modulesNameRepository;
	
	@RequestMapping(value = "/addnewmodule", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addNewModule(@RequestBody ModulesName modulesName) {
		modulesNameRepository.save(modulesName);
		return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(),"Module add successfully!"));	
	}
	
	@RequestMapping(value = "/getallmodule", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ModulesName>> getAllModule(@RequestParam String status) {
		List<ModulesName> modulesNameList =modulesNameRepository.findAllByStatus(status);
		return ResponseEntity.ok(modulesNameList);	
	}

}
