package com.springboot.login.dao;

import java.util.List;

import com.springboot.login.model.Users;

public interface UserDao {

	Users getById(String id) throws Exception;
	
	Users getByUsername(String username) throws Exception;
	
	List<Users> getAllUsers() throws Exception;

}
