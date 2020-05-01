package com.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
