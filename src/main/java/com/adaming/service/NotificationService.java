package com.adaming.service;

import java.util.List;

import com.adaming.model.Notification;
import com.adaming.model.Role;

public interface NotificationService {

	public List<Notification> getAll();
	public void deleteById(Long id);
	public Notification saveOrUpdate(Notification l);
}
