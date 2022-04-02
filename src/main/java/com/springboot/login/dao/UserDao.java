package com.springboot.login.dao;

import java.util.List;

import com.springboot.login.model.Users;

public interface UserDao {

	Users getById(String id) throws Exception;
	
	Users getByUsername(String username) throws Exception;
	
	List<Users> getAllUsers() throws Exception;
	
	void addUser(Users users) throws Exception;

	void updateUser(Users users) throws Exception;
	
	void deleteUser(String id) throws Exception;

}
