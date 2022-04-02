package com.springboot.login.dao;

import java.util.List;

import com.springboot.login.model.Roles;

public interface RoleDao {

	Roles getById(String id) throws Exception;
	
	List<Roles> getAllRoles() throws Exception;

}
