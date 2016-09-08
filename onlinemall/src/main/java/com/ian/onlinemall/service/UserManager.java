package com.ian.onlinemall.service;


import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.domain.Order;
import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;

public interface UserManager {

	/**
	 * 用户注册
	 * @param user
	 * @return 是否创建成功
	 * @throws OmException
	 */
	boolean signUp(User user) throws OmException;
	
	/**
	 * 用用户名登录
	 * @param name
	 * @param password
	 * @return 登录的用户
	 * @throws OmException
	 */
	User signInByName(String name, String password) throws OmException;
	
	/**
	 * 用email登录
	 * @param email
	 * @param password
	 * @return 登录的用户
	 * @throws OmException
	 */
	User signInByEmail(String email, String password) throws OmException;
	
	/**
	 * 用电话号码登录
	 * @param tel
	 * @param password
	 * @return 登录的用户
	 * @throws OmException
	 */
	User signInByTel(String tel, String password) throws OmException;
	
	/**
	 * 创建订单
	 * @param order
	 * @return 订单编号
	 * @throws OmException
	 */
	String createOrder(Order order) throws OmException;
	
	/**
	 * 添加商品到购物车
	 * @param goods
	 * @return 是否成功
	 * @throws OmException
	 */
	boolean addGoodsToCart(Goods goods) throws OmException;
	
	/**
	 * 从购物车删除商品
	 * @param goods
	 * @return 是否成功
	 * @throws OmException
	 */
	boolean removeGoodsFromCart(Goods goods) throws OmException;
	
	/**
	 * 清空购物车
	 * @return 是否成功
	 * @throws OmException
	 */
	boolean cleanCart() throws OmException;
	
	/**
	 * 新增地址
	 * @param address
	 * @return
	 * @throws OmException
	 */
	boolean createAddress(Address address) throws OmException;
	
	/**
	 * 删除地址
	 * @param address
	 * @return
	 * @throws OmException
	 */
	boolean deleteAddress(Address address) throws OmException;
	
	/**
	 * 设置默认地址
	 * @param address
	 * @return
	 * @throws OmException
	 */
	boolean setDefaultAddress(Address address) throws OmException;
	
	
}
