package com.springboot.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.login.dao.RoleDao;
import com.springboot.login.model.Roles;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Roles getById(String id) throws Exception {
		return roleDao.getById(id);
	}

	@Override
	public List<Roles> getAllRoles() throws Exception {
		return roleDao.getAllRoles();
	}

}
