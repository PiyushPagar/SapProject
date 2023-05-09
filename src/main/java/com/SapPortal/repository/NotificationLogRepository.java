package com.SapPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SapPortal.models.NotificationLog;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog,Long>{
	
	

}
