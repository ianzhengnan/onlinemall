package com.ian.onlinemall.service.impl;

import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.domain.Order;
import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.ian.onlinemall.service.UserManager;

public class UserManagerImpl implements UserManager{

	public boolean signUp(User user) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public User signInByName(String name, String password) throws OmException {
		// TODO Auto-generated method stub
		return null;
	}

	public User signInByEmail(String email, String password) throws OmException {
		// TODO Auto-generated method stub
		return null;
	}

	public User signInByTel(String tel, String password) throws OmException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createOrder(Order order) throws OmException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addGoodsToCart(Goods goods) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeGoodsFromCart(Goods goods) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean cleanCart() throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createAddress(Address address) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAddress(Address address) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setDefaultAddress(Address address) throws OmException {
		// TODO Auto-generated method stub
		return false;
	}

	
}
