package com.SapPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.AdminDetails;
import com.SapPortal.models.User;

@Repository
public interface AdminDetailsRepository extends JpaRepository<AdminDetails, Long> {

	Optional<AdminDetails> findByUserId(Integer userId);

}
