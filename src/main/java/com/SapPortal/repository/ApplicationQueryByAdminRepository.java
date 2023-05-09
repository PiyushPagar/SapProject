package com.SapPortal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.SapPortal.models.ApplicationQueryByAdmin;


@Repository
public interface ApplicationQueryByAdminRepository extends CrudRepository<ApplicationQueryByAdmin, Integer> {

	ApplicationQueryByAdmin findByapplicationId(int applicationId);

	List<ApplicationQueryByAdmin> findAllByApplicationIdAndIsActive(int applicationId, String string);

	ApplicationQueryByAdmin findByApplicationIdAndIsActive(int applicationId, String string);

	
	
}
