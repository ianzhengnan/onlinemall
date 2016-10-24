package com.ian.onlinemall.dao;

import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.domain.User;

import java.util.List;
import java.util.Set;

public interface CartDao extends Dao {

	/**
	 * 根据用户查找他的购物车
	 * @param user
	 * @return 找到的购物车
	 */
	Cart findCartByUser(User user);
	
	/**
	 * 添加商品到购物车
	 * @param goods
	 * @param cart
	 */
	void addGoodsToCart(Goods goods, Cart cart);
	
	/**
	 * 从购物车中删除商品
	 * @param goods
	 * @param cart
	 */
	void removeGoodsFromCart(Goods goods, Cart cart);
	
	/**
	 * 清空购物车
	 * @param cart
	 */
	void cleanCart(Cart cart);

}
