package com.ian.onlinemall.service;

import java.util.List;

import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.Cart;
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
	 * @param cart 
	 * @return 是否成功
	 * @throws OmException
	 */
	void addGoodsToCart(Goods goods, Cart cart) throws OmException;
	
	/**
	 * 从购物车删除商品
	 * @param goods
	 * @return 是否成功
	 * @throws OmException
	 */
	void removeGoodsFromCart(Goods goods, Cart cart) throws OmException;
	
	/**
	 * 清空购物车
	 * @param cart
	 * @return 是否成功
	 * @throws OmException
	 */
	boolean cleanCart(Cart cart) throws OmException;
	
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
	 * @throws OmException
	 */
	void deleteAddress(Address address) throws OmException;
	
	/**
	 * 设置默认地址
	 * @param address
	 * @throws OmException
	 */
	void setDefaultAddress(Address address) throws OmException;
	
	/**
	 * 按照商品类别获取商品
	 * @param catalog
	 * @return
	 */
	List<Goods> getGoodsByCatalog(String catalog);
	
	/**
	 * 获取所有的商品
	 * @return
	 */
	List<Goods> getAllGoods(int first,int max);
	
	/**
	 * 根据商标获取商品
	 * @param brand
	 * @return
	 */
	List<Goods> getGoodsByBrand(String brand);
	
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 * @throws OmException
	 */
	boolean createGoods(Goods goods) throws OmException;
	
	/**
	 * 创建购物车
	 * @param cart
	 * @return
	 * @throws OmException
	 */
	boolean creatCart(Cart cart) throws OmException;
	
	/**
	 * 获取指定用户的购物车
	 * @param user
	 * @return
	 */
	Cart getCartByUser(User user);
	
	/**
	 * 获取Goods
	 * @param id
	 * @return
	 */
	Goods getGoodsById(String id);

	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	User getUserById(String id);
}
