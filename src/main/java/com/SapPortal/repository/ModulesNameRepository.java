package com.SapPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.ModulesName;

@Repository
public interface ModulesNameRepository extends JpaRepository<ModulesName, Long> {

	List<ModulesName> findAllByStatus(String status);

}
