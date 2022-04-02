package com.springboot.login.service;

import java.util.List;

import com.springboot.login.model.Roles;

public interface RoleService {

	Roles getById(String id) throws Exception;

	List<Roles> getAllRoles() throws Exception;

}
