package com.SapPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SapPortal.models.SapCredentialsDatails;

public interface SapCredentialsDatailsRepository extends JpaRepository<SapCredentialsDatails,Long>{

	SapCredentialsDatails findByUserId(Long userId);

}
