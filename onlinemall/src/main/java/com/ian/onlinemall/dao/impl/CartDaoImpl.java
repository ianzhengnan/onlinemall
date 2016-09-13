package com.ian.onlinemall.dao.impl;

import java.util.List;

import com.ian.onlinemall.dao.BaseDao;
import com.ian.onlinemall.dao.CartDao;
import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.domain.User;

public class CartDaoImpl extends BaseDao implements CartDao{

	public Cart findCartByUser(User user) {
		List<Cart> carts = getResultList(Cart.class
				, "where o.user = ?1"
				, null
				, user);
		if (carts != null && carts.size() > 0) {
			return carts.get(0);
		}
		return null;
	}

	public void addGoodsToCart(Goods goods, Cart cart) {
		cart.getGoods().add(goods);
		update(cart);
	}

	public void removeGoodsFromCart(Goods goods, Cart cart) {
		cart.getGoods().remove(goods);
		update(cart);
	}

	public void cleanCart(Cart cart) {
		cart.getGoods().clear();
		update(cart);
	}
	
}