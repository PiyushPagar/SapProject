package com.SapPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SapPortal.models.PlacementDetails;


public interface PlacementDetailsRepository  extends JpaRepository<PlacementDetails, Long>{


	List<PlacementDetails> findAllByOrderByPackagesDesc();

	Optional<PlacementDetails> findByStudentfilename(String fileName);




}
