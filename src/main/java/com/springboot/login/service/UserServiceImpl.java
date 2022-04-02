package com.springboot.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.login.dao.UserDao;
import com.springboot.login.model.Users;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserDao userDao;

	@Override
	public Users getById(String id) throws Exception {
		return userDao.getById(id);
	}

	@Override
	public Users getByUsername(String username) throws Exception {
		return userDao.getByUsername(username);
	}

	@Override
	public List<Users> getAllUsers() throws Exception {
		return userDao.getAllUsers();
	}

}
