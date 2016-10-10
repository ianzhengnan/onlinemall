package com.ian.onlinemall.dao;

import java.util.List;

import com.ian.onlinemall.domain.Goods;

public interface GoodsDao extends Dao {

	/**
	 * 通过类别查找商品
	 * @param categroy
	 * @return 通过类别找到的商品列表
	 */
	List<Goods> findItemByCategroy(String categroy);
	
	/**
	 * 通过名称和描述模糊查找商品
	 * @param name
	 * @param desc
	 * @return 找到的商品列表
	 */
	List<Goods> findItemByNameOrDesc(String name, String desc);
	
	/**
	 * 根据价格查找商品
	 * @param price
	 * @return 找到的商品列表
	 */
	List<Goods> findItemBetweenPrice(double low, double high);
	
	/**
	 * 根据品牌查询商品
	 * @param brand
	 * @return 找到的商品列表
	 */
	List<Goods> findItemByBrand(String brand);
	
	/**
	 * 获取所有的商品
	 * @return
	 */
	List<Goods> findAllItems(int first, int max);
}
