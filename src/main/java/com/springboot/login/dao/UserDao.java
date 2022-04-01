package com.springboot.login.dao;

import java.util.List;

import com.springboot.login.model.Users;

public interface UserDao {

//	void insert(Users data) throws Exception;

//	void update(Users data) throws Exception;

//	void delete(Long id) throws Exception;
	
//	List<Users> getAll() throws Exception;

	Users getById(String id) throws Exception;
	
	Users getByUsername(String username) throws Exception;

}
