package com.springboot.login.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.login.dao.UserDao;
import com.springboot.login.model.Roles;
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

	@Override
	@Transactional
	public void addUser(Users user) throws Exception {
		user.setUsername(user.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		Roles role = new Roles();
		role.setId(user.getRole().getId());
		user.setRole(role);
		
		user.setCreatedBy(super.user().getUsername());
		user.setCreatedDate(LocalDateTime.now());
		user.setVersion(0L);
		user.setIsActive(true);
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void updateUser(Users user) throws Exception {
		Users users = getById(user.getId());
		if (users.getId() == null || users.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		
		user.setUsername(user.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		Roles role = new Roles();
		role.setId(user.getRole().getId());
		user.setRole(role);
		
		user.setCreatedBy(users.getCreatedBy());
		user.setCreatedDate(users.getCreatedDate());
		user.setUpdatedBy(super.user().getUsername());
		user.setUpdatedDate(LocalDateTime.now());
		user.setVersion(user.getVersion()+1L);
		userDao.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String id) throws Exception {
		Users user = new Users();
		user.setId(id);
		userDao.deleteUser(id);
	}

}
