package com.ian.onlinemall.dao;

import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.User;

public interface CartDao extends Dao {

	/**
	 * 根据用户查找他的购物车
	 * @param user
	 * @return 找到的购物车
	 */
	Cart findCartByUser(User user);
}
