package com.SapPortal.security.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.SapPortal.models.ApplicationForm;
import com.SapPortal.repository.ApplicationFormRepository;


@Service
public class ApplicationFromService {
	
	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	public List<ApplicationForm> getAllApplicationForm()   
	{
		List<ApplicationForm> applicationForm = new ArrayList<ApplicationForm>();
		applicationFormRepository.findAll().forEach(applicationForm1 -> applicationForm.add(applicationForm1));
		return applicationForm;
	}
	
	
	public ApplicationForm getApplicationFormById(int StudentId)   
	{  
	return applicationFormRepository.findById(StudentId).get();  
	}  

	public void saveOrUpdate(ApplicationForm applicationForm)   
	{  
		applicationFormRepository.save(applicationForm);  
	}  
	public void delete(int StudentId)   
	{  
		applicationFormRepository.deleteById(StudentId);  
	}  	 
	public void update(ApplicationForm applicationForm, int StudentId)   
	{  
		applicationFormRepository.save(applicationForm);  
	}  
  

}
