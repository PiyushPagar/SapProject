package com.SapPortal.service;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.SapPortal.models.ApplicationForm;
import com.SapPortal.repository.ApplicationFormRepository;
import com.SapPortal.repository.CustomRepository;


@Repository
public  class CustomRepositoryImpl implements CustomRepository{
	
	@Autowired
	ApplicationFormRepository applicationFormRepository;
	
	@Override
	public Page<ApplicationForm > findApplicationFormByFilter(Integer pagenum, Integer pagesize,Integer StudentId,String email
			,String name,
			String collegeEmail,String sapModule, String contactNumber,String passoutYear,String branch,String specialization,
			String studentType,String adhaarCard,String applicationFromStatus, Long userId,Boolean isQueryInApplication,Pageable pageable) {
		    Page<ApplicationForm> pager = applicationFormRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (StudentId != null && !StudentId.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("StudentId"), StudentId )));
            }
            if (email != null && !email.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("email"),"%"+email+"%")));
            }
            if (name != null && !name.equals("") ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("name"), "%"+name+"%")));
            }
            if (collegeEmail != null && !collegeEmail.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("collegeEmail"),  "%"+collegeEmail+"%")));
            }
            if (sapModule != null  && !sapModule.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("sapModule"), sapModule)));
            }
            if (contactNumber != null  && !contactNumber.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("contactNumber"), "%"+contactNumber+"%")));
            }
            if (passoutYear != null && !passoutYear.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("passoutYear"),  passoutYear)));
            }
            if (branch != null && !branch.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("branch"),  branch)));
            }
            if (specialization != null && !specialization.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("specialization"),  "%"+specialization+"%")));
            }
            if (adhaarCard != null && !adhaarCard.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("adhaarCard"),  "%"+adhaarCard+"%")));
            }
            if (applicationFromStatus != null && !applicationFromStatus.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("applicationFromStatus"),  applicationFromStatus)));
            }
            if (isQueryInApplication != null && !isQueryInApplication.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("isQueryInApplication"), isQueryInApplication)));
            }
            if (userId != null && !userId.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("userId"),  userId)));
            }
            
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);
    return pager;	
	}
	
	
   
}
