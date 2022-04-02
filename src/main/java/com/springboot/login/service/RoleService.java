package com.springboot.login.service;

import java.util.List;

import com.springboot.login.model.Roles;

public interface RoleService {

	Roles getById(String id) throws Exception;

	List<Roles> getAllRoles() throws Exception;

	void addRole(Roles roles) throws Exception;

	void updateRole(Roles roles) throws Exception;
	
	void deleteRole(String id) throws Exception;
}
