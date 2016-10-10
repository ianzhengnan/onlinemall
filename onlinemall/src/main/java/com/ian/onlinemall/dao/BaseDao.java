package com.ian.onlinemall.dao;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BaseDao implements Dao{

	private EntityManagerFactory emf;
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEmf(EntityManagerFactory emf){
		this.emf = emf;
		if (em == null) {
			em = this.emf.createEntityManager();
		}
	}
	
	public EntityManagerFactory geEntityManagerFactory(){
		return this.emf;
	}

	public <T> T get(Class<T> entityClass, Object pk) {

		T obj = em.find(entityClass, pk);
		return obj;
	}
	
	public void save(Object entity){

		try{
			em.persist(entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void update(Object entity){

		em.merge(entity);
	}

	public void delete(Class<?> entityClass, Object pk) {

		em.remove(em.getReference(entityClass, pk));
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getResultList(Class<T> entityClass, String whereJpql, LinkedHashMap<String, String> orderBy,
			Object... args) {

		String entityName = entityClass.getSimpleName();
		
		Query query = em.createQuery("select o from " + entityName
				+ " as o " + whereJpql + buildOrderBy(orderBy));
		
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i + 1, args[i]);
		}
		
		return (List<T>)query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getResultList(Class<T> entityClass, String whereJpql, int firstResult, int maxResult,
			LinkedHashMap<String, String> orderBy, Object... args) {

		String entityName = entityClass.getSimpleName();
		
		Query query = em.createQuery("select o from " + entityName
				+ " as o " + whereJpql + buildOrderBy(orderBy));
		
		if(args != null){
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i+1, args[i]);
			}
		}
		
		query.setFirstResult(firstResult).setMaxResults(maxResult);
		
		return (List<T>)query.getResultList();
	}
	
	private static String buildOrderBy(LinkedHashMap<String, String> orderBy){
		StringBuffer out = new StringBuffer("");
		
		if (orderBy != null && orderBy.size() > 0) {
			out.append(" order by ");
			for (String key : orderBy.keySet()) {
				out.append("o." + key + " " + orderBy.get(key));
				out.append(",");
			}
			out.deleteCharAt(out.length() - 1);
		}
		return out.toString();
	}

}
