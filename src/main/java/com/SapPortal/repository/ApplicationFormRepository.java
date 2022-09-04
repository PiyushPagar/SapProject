package com.SapPortal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.ApplicationForm;
@Repository
public interface ApplicationFormRepository extends CrudRepository<ApplicationForm, Integer> {

}