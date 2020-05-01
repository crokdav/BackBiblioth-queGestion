package com.adaming.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;


import javax.websocket.server.PathParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.model.UserManager;
import com.adaming.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService UserService;
	/*
	@RequestMapping(value="/findByLogin",method=RequestMethod.GET)
	public UserManager findByLogin(@PathParam("login") String login)
	{
		return UserService.findByLogin(login);
	}*/

	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<UserManager> findALL()
	{
		return UserService.findALL();
	}

	private static int workload = 10;

	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
		return (hashed_password);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody String obj) 
			throws JsonParseException, JsonMappingException, IOException {
		{
			    ObjectMapper mapper = new ObjectMapper();
				UserManager u = mapper.readValue(obj.toString(), UserManager.class);
				u.setPassword(hashPassword(u.getPassword()));
				UserService.savOrUpdate(u);

			
		}
	}
	
	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) 
	{
		UserService.deleteById(id);
	}
}