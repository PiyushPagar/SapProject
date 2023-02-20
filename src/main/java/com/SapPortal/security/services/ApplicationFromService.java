package com.SapPortal.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SapPortal.dto.PagesDto;
import com.SapPortal.models.ApplicationForm;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.repository.CustomRepository;

@Service
public class ApplicationFromService {

	@Autowired
	ApplicationFormRepository applicationFormRepository;
	@Autowired
	CustomRepository customRepository;

	public List<ApplicationForm> getAllApplicationForm() {
		List<ApplicationForm> applicationForm = new ArrayList<ApplicationForm>();
		applicationFormRepository.findAll().forEach(applicationForm1 -> applicationForm.add(applicationForm1));
		return applicationForm;
	}

	public ApplicationForm getApplicationFormById(int StudentId) {
		return applicationFormRepository.findById(StudentId).get();
	}
//	
//	public ApplicationForm getApplicationFormByuserId(int userId)   
//	{  
//	return applicationFormRepository.findById(userId).get();  
//	}

	public void saveOrUpdate(ApplicationForm applicationForm) {
		applicationFormRepository.save(applicationForm);
	}

	public void delete(int StudentId) {
		applicationFormRepository.deleteById(StudentId);
	}

	public void update(ApplicationForm applicationForm, int StudentId) {
		applicationFormRepository.save(applicationForm);
	}

	public PagesDto<ApplicationForm> listOfApplicationFormFilter(Integer pagenum, Integer pagesize, String email,
			Integer studentId, String name, String collegeEmail, String sapModule, String contactNumber,
			String passoutYear, String branch, String specialization, String studentType, String adhaarCard,
			Boolean uploadImage, String applicationFromStatus, Long userId) {
		PagesDto<ApplicationForm> pagesApplicationFormlist = new PagesDto<>();
		try {
			Pageable pageable = PageRequest.of(pagenum, pagesize);
			Page<ApplicationForm> applicationForm = null;
			applicationForm = customRepository.findApplicationFormByFilter(pagenum, pagesize, studentId, email, name,
					collegeEmail, sapModule, contactNumber, passoutYear, branch, specialization, studentType,
					adhaarCard, applicationFromStatus, userId, uploadImage, pageable);
			Long total = applicationForm.getTotalElements();
			pagesApplicationFormlist.setPage(Integer.valueOf(pagenum));
			pagesApplicationFormlist.setTotal(String.valueOf(total));
			pagesApplicationFormlist.setRows(String.valueOf(Math.ceil((double) total / pagesize)));
			List<ApplicationForm> applicationFormdto = new ArrayList<>();
			applicationForm.stream().forEach(al -> {
				ApplicationForm ApplicationForm = getApplicationForm(al);
				applicationFormdto.add(ApplicationForm);
			});
			pagesApplicationFormlist.setRecords(applicationFormdto);
		} catch (Exception e) {
			System.out.println(e);
		}
		return pagesApplicationFormlist;
	}

	public ApplicationForm getApplicationForm(ApplicationForm applicationForm) {
		ApplicationForm applicationFormNew = new ApplicationForm();
		applicationFormNew.setAdhaarCard(applicationForm.getAdhaarCard());
		applicationFormNew.setApplicationFromStatus(applicationForm.getApplicationFromStatus());
		applicationFormNew.setBranch(applicationForm.getBranch());
		applicationFormNew.setCollegeEmail(applicationForm.getCollegeEmail());
		applicationFormNew.setContactNumber(applicationForm.getContactNumber());
		applicationFormNew.setEmail(applicationForm.getEmail());
		applicationFormNew.setIsQueryInApplication(applicationForm.getIsQueryInApplication());
		applicationFormNew.setName(applicationForm.getName());
		applicationFormNew.setPassoutYear(applicationForm.getPassoutYear());
		applicationFormNew.setSapModule(applicationForm.getSapModule());
		applicationFormNew.setSpecialization(applicationForm.getSpecialization());
		applicationFormNew.setStudentId(applicationForm.getStudentId());
		applicationFormNew.setStudentType(applicationForm.getStudentType());
		applicationFormNew.setUploadImage(applicationForm.getUploadImage());
		applicationFormNew.setUserId(applicationForm.getUserId());
		return applicationFormNew;
	}

}
