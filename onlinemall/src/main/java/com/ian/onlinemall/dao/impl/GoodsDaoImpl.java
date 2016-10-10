package com.ian.onlinemall.dao.impl;

import java.util.List;

import com.ian.onlinemall.dao.BaseDao;
import com.ian.onlinemall.dao.GoodsDao;
import com.ian.onlinemall.domain.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao{

	public List<Goods> findItemByCategroy(String categroy) {
		List<Goods> goods = getResultList(Goods.class
				, "where o.category = ?1"
				, null
				, categroy);
		if (goods != null && goods.size() > 0) {
			return goods;
		}
		return null;
	}

	public List<Goods> findItemByNameOrDesc(String name, String desc) {
		List<Goods> goods = getResultList(Goods.class
				, "where o.name like %?1% or o.description like %?2%"
				, null
				, name, desc);
		if (goods != null && goods.size() > 0) {
			return goods;
		}
		return null;
	}

	public List<Goods> findItemBetweenPrice(double low, double high) {
		List<Goods> goods = getResultList(Goods.class
				, "where o.price <= ?1 and o.price >= ?2"
				, null
				, low, high);
		if (goods != null && goods.size() > 0) {
			return goods;
		}
		return null;
	}

	public List<Goods> findItemByBrand(String brand) {
		List<Goods> goods = getResultList(Goods.class
				, "where o.brand = ?1"
				, null
				, brand);
		if (goods != null && goods.size() > 0) {
			return goods;
		}
		return null;
	}

	public List<Goods> findAllItems(int first, int max) {
		Object[] arg = null;
		List<Goods> goods = getResultList(Goods.class, "", first, max, null, arg);
		if (goods != null && goods.size() > 0) {
			return goods;
		}
		return null;
	}

}
