package com.ian.onlinemall.dao;

import java.util.List;

import com.ian.onlinemall.domain.Order;
import com.ian.onlinemall.domain.User;

public interface OrderDao extends Dao {

	/**
	 * 通过用户查找订单
	 * @param user
	 * @return 返回该用户的所有订单
	 */
	List<Order> findItemByUser(User user);
}
