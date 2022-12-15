package com.poly.Dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.Dao.AbstractDao;
import com.poly.Dao.UserDao;
import com.poly.constant.NamedStored;
import com.poly.entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao{

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User finByEmail(String email) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT o FROM User o WHERE o.username = ?0";
			return super.findOne(User.class, sql, username);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	/*public User create(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User entity) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<User> findUsersLikedByVideoHref(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.callStored(NamedStored.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}
}
