package com.SapPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.ContactUs;


@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {

}
