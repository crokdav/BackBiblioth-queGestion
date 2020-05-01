package com.adaming.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.dao.NotificationRepository;
import com.adaming.model.Notification;
import com.adaming.service.NotificationService;

@Service
public class NotificationServiceImp implements NotificationService{

	
	@Autowired
	NotificationRepository notificationRep;
	
	@Override
	public List<Notification> getAll() {
		return notificationRep.findAll();
	}

	@Override
	public void deleteById(Long id) {
		notificationRep.deleteById(id);;
		
	}

	@Override
	public Notification saveOrUpdate(Notification l) {
		return notificationRep.save(l);
	}

}
