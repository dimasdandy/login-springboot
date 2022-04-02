package com.springboot.login.service;

import java.util.List;

import com.springboot.login.model.Users;

public interface UserService {

	Users getById(String id) throws Exception;
	
	Users getByUsername(String username) throws Exception;
	
	List<Users> getAllUsers() throws Exception;

}
