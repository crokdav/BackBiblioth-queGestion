package com.adaming.service;

import java.util.List;

import com.adaming.model.Role;

public interface RoleService {
	public List<Role> getAll();
	public void deleteById(Long id);
	public Role saveOrUpdate(Role l);

}
