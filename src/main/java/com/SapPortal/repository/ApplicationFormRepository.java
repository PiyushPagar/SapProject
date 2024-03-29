package com.SapPortal.repository;

import java.util.List;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.ApplicationForm;
@Repository
public interface ApplicationFormRepository extends CrudRepository<ApplicationForm, Integer> {
	
	@Query(value = "SELECT * FROM application_form t WHERE t.user_id =:clientId", nativeQuery = true)
	ApplicationForm findByUseridLike(Integer clientId);

	
	<T> Page<ApplicationForm> findAll(Specification<T> example, Pageable page);
	
	
	ApplicationForm findApplicationFormByUserId(Long id);

	
	@Query(value = "SELECT * FROM sap_portal.application_form where application_from_status in ( :status)", nativeQuery = true)
	List<ApplicationForm> findAllApplicationByStatus(@Param("status") List<String> status);




}