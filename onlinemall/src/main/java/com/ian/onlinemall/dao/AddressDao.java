package com.ian.onlinemall.dao;

import java.util.List;

import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.User;

public interface AddressDao extends Dao{

	/**
	 * 通过用户查找地址
	 * @param user
	 * @return 查找到的地址列表
	 */
	List<Address> findItemByUser(User user);
}
