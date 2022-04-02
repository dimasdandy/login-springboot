package com.springboot.login.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.login.model.Roles;
import com.springboot.login.model.Users;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public Users getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u.id, u.id_role, r.code AS role_code, ")
		.append("r.name AS role_name, u.username, u.created_by, ")
		.append("u.created_date, u.updated_by, u.updated_date, ") 
		.append("u.VERSION, u.is_active ") 
		.append("FROM tbl_users u ")
		.append("JOIN tbl_roles r ON r.id = u.id_role ")
		.append("WHERE u.id = :id");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("id", id)
				.getResultList();
		
		Users users = new Users();
		Roles roles = new Roles();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			users.setId(data[0] != null ? data[0].toString() : null);
			roles.setId(data[1] != null ? data[1].toString() : null);
			roles.setCode(data[2] != null ? data[2].toString() : null);
			roles.setName(data[3] != null ? data[3].toString() : null);
			users.setRole(roles);
			users.setUsername(data[4] != null ? data[4].toString() : null);
			users.setCreatedBy(data[5] != null ? data[5].toString() : null);
			users.setCreatedDate(data[6] != null ? ((Timestamp)data[6]).toLocalDateTime() : null);
			users.setUpdatedBy(data[7] != null ? data[7].toString() : null);
			users.setUpdatedDate(data[8] != null ? ((Timestamp)data[8]).toLocalDateTime() : null);
			users.setVersion(data[9] != null ? Long.valueOf(data[9].toString()) : null);
			users.setIsActive(data[10] != null ? (Boolean)data[10] : null);
		});
		return users;
	}

	@Override
	public Users getByUsername(String username) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u.id, u.id_role, r.code AS role_code, ")
		.append("r.name AS role_name, u.username, u.password ")
		.append("FROM tbl_users u ")
		.append("JOIN tbl_roles r ON r.id = u.id_role ")
		.append("WHERE u.username = :username");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("username", username)
				.getResultList();
		
		Users users = new Users();
		Roles roles = new Roles();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			users.setId(data[0] != null ? data[0].toString() : null);
			roles.setId(data[1] != null ? data[1].toString() : null);
			roles.setCode(data[2] != null ? data[2].toString() : null);
			roles.setName(data[3] != null ? data[3].toString() : null);
			users.setRole(roles);
			users.setUsername(data[4] != null ? data[4].toString() : null);
			users.setPassword(data[5] != null ? data[5].toString() : null);
		});
		return users;
	}

	@Override
	public List<Users> getAllUsers() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u.id, u.id_role, r.code AS role_code, ")
		.append("r.name AS role_name, u.username, u.created_by, ")
		.append("u.created_date, u.updated_by, u.updated_date, ") 
		.append("u.VERSION, u.is_active ") 
		.append("FROM tbl_users u ")
		.append("JOIN tbl_roles r ON r.id = u.id_role ")
		.append("WHERE u.is_active = true");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.getResultList();
		
		List<Users> listUsers = new ArrayList<Users>();

		list.forEach(val -> {
			Object[] data = (Object[]) val;
			Users users = new Users();
			users.setId(data[0] != null ? data[0].toString() : null);
			Roles roles = new Roles();
			roles.setId(data[1] != null ? data[1].toString() : null);
			roles.setCode(data[2] != null ? data[2].toString() : null);
			roles.setName(data[3] != null ? data[3].toString() : null);
			users.setRole(roles);
			users.setUsername(data[4] != null ? data[4].toString() : null);
			users.setCreatedBy(data[5] != null ? data[5].toString() : null);
			users.setCreatedDate(data[6] != null ? ((Timestamp)data[6]).toLocalDateTime() : null);
			users.setUpdatedBy(data[7] != null ? data[7].toString() : null);
			users.setUpdatedDate(data[8] != null ? ((Timestamp)data[8]).toLocalDateTime() : null);
			users.setVersion(data[9] != null ? Long.valueOf(data[9].toString()) : null);
			users.setIsActive(data[10] != null ? (Boolean)data[10] : null);
			listUsers.add(users);
		});
		return listUsers;
	}

}
