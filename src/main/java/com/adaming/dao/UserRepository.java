package com.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adaming.model.UserManager;

public interface UserRepository extends JpaRepository<UserManager, Long> {
	
public UserManager findByLogin(String login);
}
