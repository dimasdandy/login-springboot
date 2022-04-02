package com.springboot.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.login.model.Roles;

@Repository
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Roles getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT role.* ")
		.append("FROM tbl_roles role ") 
		.append("WHERE role.id = (:id)\\:\\:text ") 
		.append("AND role.is_active = true ");
		
		List<Roles> list = em.createNativeQuery(sb.toString(), Roles.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAllRoles() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT role.* ")
		.append("FROM tbl_roles role ") 
		.append("WHERE role.is_active = true ");
		
		List<Roles> list = em.createNativeQuery(sb.toString(), Roles.class)
				.getResultList();
		
		return list;
	}

}
