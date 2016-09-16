package com.ian.onlinemall.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.ian.onlinemall.dao.AddressDao;
import com.ian.onlinemall.dao.CartDao;
import com.ian.onlinemall.dao.OrderDao;
import com.ian.onlinemall.dao.UserDao;
import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.domain.Order;
import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.ian.onlinemall.service.UserManager;

@Transactional
public class UserManagerImpl implements UserManager{

	private UserDao userDao;
	private OrderDao orderDao;
	private CartDao cartDao;
	private AddressDao addressDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public boolean signUp(User user) throws OmException {
		
		userDao.save(user);
		if (user.getUuid().length() > 0) {
			return true;
		}
		return false;
	}

	public User signInByName(String name, String password) throws OmException {

		return userDao.findUserByNameAndPass(name, password);
	}

	public User signInByEmail(String email, String password) throws OmException {
		
		return userDao.findUserByEmailAndPass(email, password);
	}

	public User signInByTel(String tel, String password) throws OmException {
		
		return userDao.findUserByTelAndPass(tel, password);
	}

	public String createOrder(Order order) throws OmException {
		
		orderDao.save(order);
		if (order.getUuid().length() > 0) {
			return order.getNumber();
		}
		return null;
	}

	
	public Set<Goods> addGoodsToCart(Goods goods, Cart cart) throws OmException {

		cartDao.addGoodsToCart(goods, cart);
		return cart.getGoods();
	}

	public Set<Goods> removeGoodsFromCart(Goods goods, Cart cart) throws OmException {

		cartDao.removeGoodsFromCart(goods, cart);
		return cart.getGoods();
	}

	public boolean cleanCart(Cart cart) throws OmException {
		cartDao.cleanCart(cart);
		if (cart.getGoods().isEmpty() == true) {
			return true;
		}
		return false;
	}

	public boolean createAddress(Address address) throws OmException {
		addressDao.save(address);
		if (address.getUuid().length() > 0) {
			return true;
		}
		return false;
	}

	public void deleteAddress(Address address) throws OmException {
		addressDao.delete(Address.class, address.getUuid());		
	}

	public void setDefaultAddress(Address address) throws OmException {
		address.setDefault(true);
		addressDao.update(address);
	}
	
}
