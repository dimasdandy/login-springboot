package com.springboot.login.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

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

	@Override
	@Transactional
	public void addRole(Roles roles) throws Exception {
		roles.setCode(roles.getCode());
		roles.setName(roles.getName());
		roles.setCreatedBy(super.user().getUsername());
		roles.setCreatedDate(LocalDateTime.now());
		roles.setVersion(0L);
		roles.setIsActive(true);
		roleDao.addRole(roles);
	}

	@Override
	@Transactional
	public void updateRole(Roles roles) throws Exception {
		Roles role = getById(roles.getId());
		if (role.getId() == null || role.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		
		roles.setCode(roles.getCode());
		roles.setName(roles.getName());
		roles.setCreatedBy(role.getCreatedBy());
		roles.setCreatedDate(role.getCreatedDate());
		roles.setUpdatedBy(super.user().getUsername());
		roles.setUpdatedDate(LocalDateTime.now());
		roles.setVersion(roles.getVersion()+1L);
		roleDao.updateRole(roles);
	}

	@Override
	@Transactional
	public void deleteRole(String id) throws Exception {
		Roles role = new Roles();
		role.setId(id);
		roleDao.deleteRole(id);
	}

}
