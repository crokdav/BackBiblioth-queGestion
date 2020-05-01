package com.adaming.service;

import java.util.List;

import com.adaming.model.UserManager;

public interface UserService {
	
	public UserManager findByLogin(String login);
	public List<UserManager> findALL();
	public UserManager savOrUpdate(UserManager u);
	public void deleteById(int id);

}
