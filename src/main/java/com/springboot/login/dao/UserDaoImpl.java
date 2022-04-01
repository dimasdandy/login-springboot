package com.springboot.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.springboot.login.model.Roles;
import com.springboot.login.model.Users;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

//	@Override
//	public void insert(Users data) throws Exception {
//		em.persist(data);
//	}

//	@Override
//	public void update(Users data) throws Exception {
//		em.merge(data);
//
//	}

//	@Override
//	public void delete(Long id) throws Exception {
//		String sql = "delete from tb_m_users where id =:id";
//		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
//	}

//	@Override
//	public List<Users> getAll() throws Exception {
//		String sql = "select u from Users u where isActive = true";
//		List<Users> listObj = em.createQuery(sql, Users.class).getResultList();
//		return listObj;
//	}

	@Override
	public Users getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u.id, u.id_role, r.code, r.name, ") 
		.append("u.username, u.version, u.is_active ")
		.append("FROM tbl_users u ")
		.append("JOIN tbl_roles r ON r.id = u.id_role ")
		.append("WHERE u.id = (:id)\\:\\:text");
		
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
			users.setVersion(data[5] != null ? Long.valueOf(data[5].toString()) : null);
			users.setIsActive(data[6] != null ? Boolean.valueOf(data[6].toString()) : null);
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

}
