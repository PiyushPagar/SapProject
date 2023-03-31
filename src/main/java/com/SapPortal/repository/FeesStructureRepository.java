package com.SapPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SapPortal.models.FeesStructure;
import com.SapPortal.models.ModulesName;

public interface FeesStructureRepository extends JpaRepository<FeesStructure, Long> {

	FeesStructure findBystudentType(String studentType);

	List<FeesStructure> findAllByStatus(String status);

}
