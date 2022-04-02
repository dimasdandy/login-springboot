package com.springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.login.model.Users;
import com.springboot.login.security.AuthPrincipal;

@Service
public class BaseServiceImpl {

	@Autowired
	private AuthPrincipal authPrincipal;
	
	@Autowired
	private UserService usersService;
	
	public Users user() throws Exception{
		String id = authPrincipal.getAuthentication();
        Users user = usersService.getById(id);
		return user;
	}
}
