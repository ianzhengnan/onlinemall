package com.ian.onlinemall.dao.impl;

import java.util.List;

import com.ian.onlinemall.dao.BaseDao;
import com.ian.onlinemall.dao.OrderDao;
import com.ian.onlinemall.domain.Order;
import com.ian.onlinemall.domain.User;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	public List<Order> findItemByUser(User user) {
		List<Order> orders = getResultList(Order.class
				, "where o.user = ?1"
				, null
				, user);
		if (orders != null && orders.size() > 0) {
			return orders;
		}
		return null;
	}

}
