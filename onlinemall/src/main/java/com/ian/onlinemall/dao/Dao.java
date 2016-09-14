package com.ian.onlinemall.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.ian.onlinemall.exception.OmException;

public interface Dao {

	/**
	 * 查找实体
	 * @param <T> 动态传入实体类
	 * @param entityClass
	 * @param pk 主键
	 * @return
	 */
	<T> T get(Class<T> entityClass, Object pk);
	
	/**
	 * 保存实体
	 * @param entity 需要保存的实体
	 */
	void save(Object entity) throws OmException;
	
	/**
	 * 更新实体
	 * @param entity 需要更新的实体
	 */
	void update(Object entity);
	
	/**
	 * 删除实体
	 * @param entityClass 需要删除的实体类
	 * @param pk 需要删除的实体的主键
	 */
	void delete(Class<?> entityClass, Object pk);
	
	/**
	 * 执行查询方法
	 * @param entityClass 实体类
	 * @param whereJpql 指定查询需要的where jpql语句
	 * @param orderBy 用于排序，如果无需排序，该参数设为null, Map对象的key为实体字段名
	 * value为ASC/DESC, 如：LinkedHashMap<String, String> orderBy
	 * 	= new LinkedHashMap<String, String>();
	 * orderBy.put("itemName", "DESC");表明根据ItemName降序排列
	 * 如果有多个key-value对，则第一次放入的key-value对为首要排序关键字
	 * @param args 作为JPQL查询字符串的参数值
	 * @return 返回查询得到的实体List
	 */
	<T> List<T> getResultList(Class<T> entityClass
			, String whereJpql
			, LinkedHashMap<String, String> orderBy
			, Object... args);
	
	/**
	 * 带分页功能的查询方法
	 * @param entityClass 实体类
	 * @param whereJpql 指定查询需要的where jpql语句
	 * @param firstResult 指定查询返回的第一条记录
	 * @param maxResult 指定最多返回多少条记录
	 * @param orderBy 用于排序，如果无需排序，该参数设为null, Map对象的key为实体字段名
	 * value为ASC/DESC, 如：LinkedHashMap<String, String> orderBy
	 * 	= new LinkedHashMap<String, String>();
	 * orderBy.put("itemName", "DESC");表明根据ItemName降序排列
	 * 如果有多个key-value对，则第一次放入的key-value对为首要排序关键字
	 * @param args 作为JPQL查询字符串的参数值
	 * @return 返回查询得到的实体List
	 */
	<T> List<T> getResultList(Class<T> entityClass
			, String whereJpql
			, int firstResult
			, int maxResult
			, LinkedHashMap<String, String> orderBy
			, Object...args);
}
