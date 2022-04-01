package com.springboot.login.service;

import java.util.List;

import com.springboot.login.model.Users;

public interface UserService {

//	Long insert(InsertUserReqDto users) throws Exception;

//	void update(UpdateUserReqDto data) throws Exception;

//	void delete(Long id) throws Exception;

//	List<FindAllPathUsersResData> getAll() throws Exception;

	Users getById(String id) throws Exception;
	
	Users getByUsername(String username) throws Exception;

}
