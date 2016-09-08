package com.ian.onlinemall.dao.impl;

import java.util.List;

import com.ian.onlinemall.dao.BaseDao;
import com.ian.onlinemall.dao.UserDao;
import com.ian.onlinemall.domain.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	public User findUserByNameAndPass(String username, String password) {

		List<User> userList = getResultList(User.class
				, "where o.name = ?1 and o.password = ?2"
				, null
				, username , password);
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}
}
