package com.poly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.Dao.UserDao;
import com.poly.Dao.impl.UserDaoImpl;
import com.poly.entity.User;
import com.poly.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao;
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public User finByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.finByEmail(email);
	}
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}
	@Override
	public User resetPassword(String email) {
		// TODO Auto-generated method stub
		User existUser = finByEmail(email);
		if(existUser != null) {
			String newPass = String.valueOf((int) (Math.random() *((9999-1000)+1))+1000);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNumber, pageSize);
	}
	@Override
	public User create(String username, String password, String email) {
		// TODO Auto-generated method stub
		User newUser = new User();
		//0,username,password,email,Boolean.FALSE,Boolean.TRUE
		//newUser.setId(5);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);		
		return dao.create(newUser);
	}
	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@Override
	public User delete(String username) {
		// TODO Auto-generated method stub
		User Olduser = dao.findByUsername(username);
		Olduser.setIsActive(Boolean.FALSE);
		return dao.update(Olduser);
	}
	@Override
	public List<User> findUsersLikedVideoByVideoHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		return dao.findUsersLikedByVideoHref(params);
	}
	
}
