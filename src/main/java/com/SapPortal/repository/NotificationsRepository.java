package com.SapPortal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.Notifications;

@Repository
public interface NotificationsRepository extends CrudRepository<Notifications, Integer> {

	Notifications findById(Long notificationDataId);

}
