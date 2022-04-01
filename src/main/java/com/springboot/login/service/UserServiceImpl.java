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

//	@Autowired
//	private RolesService rolesService;
	
//	@Override
//	@Transactional
//	public Long insert(InsertUserReqDto data) throws Exception {
//		Users users = new Users();
//		Roles roles = rolesService.getById(data.getRole());
//		users.setName(data.getName());
//		users.setUsername(data.getUsername());
//		users.setPassword(bCryptPasswordEncoder.encode(data.getPassword()));
//		users.setRole(roles);
//		users.setCreatedBy(super.users());
//		users.setIsActive(data.getIsActive());
//		usersDao.insert(users);
//		return users.getId();
//	}
//
//	@Override
//	@Transactional
//	public void update(UpdateUserReqDto data) throws Exception {
//		userValidation.updateValidation(data);
//		
//		Users users = getById(data.getId());
//		Roles roles = rolesService.getById(data.getRole());
//
//		users.setName(data.getName());
//		users.setUsername(data.getUsername());
//		users.setRole(roles);
//		users.setUpdatedBy(super.users());
//		users.setIsActive(data.getIsActive());
//		users.setVersion(data.getVersion());
//		usersDao.update(users);
//
//		Users usersUpdate = usersDao.getById(data.getId());
//		data.setVersion(usersUpdate.getVersion());
//	}
//
//	@Override
//	@Transactional
//	public void delete(Long id) throws Exception {
//		DeleteUserReqDto delete = new DeleteUserReqDto();
//		delete.setId(id);
//		userValidation.deleteValidation(delete);
//		usersDao.delete(id);
//	}
//
//	@Override
//	public List<FindAllPathUsersResData> getAll() throws Exception {
//		List<FindAllPathUsersResData> findAll = new ArrayList<FindAllPathUsersResData>();
//
//		List<Users> users = usersDao.getAll();
//		for (Users user : users) {
//			FindAllPathUsersResData allPath = new FindAllPathUsersResData();
//			allPath.setId(user.getId());
//			allPath.setName(user.getName());
//			allPath.setUsername(user.getUsername());
//			allPath.setRoleId(user.getRole().getId());
//			allPath.setRoleCode(user.getRole().getCode());
//			allPath.setRoleName(user.getRole().getName());
//			findAll.add(allPath);
//		}
//		return findAll;
//	}

	@Override
	public Users getById(String id) throws Exception {
		return userDao.getById(id);
	}

	@Override
	public Users getByUsername(String username) throws Exception {
		return userDao.getByUsername(username);
	}

}
