package com.moke.jpa.util;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * 
 * @author L 
 * @time     2014年10月8日 下午1:51:40
 * 
 * @目的 编写通用的DAO模板
 * 
 * @技术  泛型
 *
 */

public class SimpleHibernateTemplate<T, PK extends Serializable> {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	private SessionFactory sessionFactory;	
	private Class<T> entityClass;
	
	public SimpleHibernateTemplate(
			SessionFactory sessionFactory,Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void create(T entity) {
		Assert.notNull(entity);
		getSession().save(entity);
	}
	
	public void save(T entity) {
		Assert.notNull(entity);
		getSession().saveOrUpdate(entity);
	}
	
	public void delete(T entity) {
		if (entity == null) { return ;}
		getSession().delete(entity);
	}
	
	public void delete(PK id) {
		Assert.notNull(id);
		delete(get(id));
	}
	
	public T get(final PK id) {
		return (T)getSession().get(entityClass, id);
	}
	
	public List<T> findAll() {
		return findByCriteria();
	}
	
	public List<T> findByCriteria(Criterion... criterions) {
		return createCriteria(criterions).list();
	}
	
	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}
	
	
	
	
	
	
}
