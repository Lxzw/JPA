package com.moke.jpa.usermanager.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moke.jpa.usermanager.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void saveOrUpdate(User user)  {
		
	}
	
	@SuppressWarnings("unchecked")
	public  List<User> findAll() {
		String hsql = "FROM User u";
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		users = session.createQuery(hsql).list();
		session.getTransaction().commit();
		return users;
	}

}
