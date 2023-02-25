package com.SapPortal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.SapPortal.models.ApplicationForm;


public interface CustomRepository {
	

	
	Page<ApplicationForm > findApplicationFormByFilter(Integer pagenum, Integer pagesize,Integer StudentId,String email,String name,
			String collegeEmail,String sapModule, String contactNumber,String passoutYear,String branch,String specialization,
			String studentType,String adhaarCard,String applicationFromStatus, Long userId,Boolean isQueryInApplication,Pageable pageable);
    

}
