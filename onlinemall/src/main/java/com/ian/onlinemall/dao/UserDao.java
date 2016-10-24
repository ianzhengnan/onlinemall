package com.ian.onlinemall.dao;

import com.ian.onlinemall.domain.User;

public interface UserDao extends Dao{

	/**
	 * 根据用户名，密码查找用户
	 * @param username
	 * @param password
	 * @return 指定用户名，密码的用户
	 */
	User findUserByNameAndPass(String username, String password);
	
	/**
	 * 根据用户电子邮件和密码查找用户
	 * @param email
	 * @param password
	 * @return 指定用户名，密码的用户
	 */
	User findUserByEmailAndPass(String email, String password);
	
	/**
	 * 根据用户电话号码和密码查找用户
	 * @param tel
	 * @param password
	 * @return 指定用户名，密码的用户
	 */
	User findUserByTelAndPass(String tel, String password);

}
