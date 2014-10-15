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
		Session session = sessionFactory.getCurrentSession();
		if (user.getId() != null) {
			if (user.equals(findById(user.getId()))) {
				session.beginTransaction();
				session.createQuery("UPDATE User u SET u.name = ?1,u.age =?2 WHERE u.id = ?3")
				.setParameter(1, user.getName())
				.setParameter(2, user.getAge())
				.setParameter(3, user.getId()).executeUpdate();
				session.getTransaction().commit();
			} else {
		//		session.getTransaction().commit();
			}
		} else {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
		
//		session.createQuery("UPDATE User u " 
//		+ "SET u.name = ?1" 
//		+ "WHERE u.age = ?2")
//		.setParameter(1, user.getName())
//		.setParameter(2, user.getAge())
//		.executeUpdate();
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
	
	public User findById(Long id) {
		User user = new User();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		user = (User) session.get(User.class, user.setId(id));
		session.getTransaction().commit();
		return user;
	}

}
