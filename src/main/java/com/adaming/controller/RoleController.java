package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.model.Role;
import com.adaming.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	
	@Autowired
	RoleService service;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Role> findALL()
	{
		return service.getAll();
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void addUser(@RequestBody Role l) 
	{
		service.saveOrUpdate(l);
	}
	
	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) 
	{
		service.deleteById(id);
	}
}
