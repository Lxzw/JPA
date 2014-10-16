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

/**
 * 
 * @author L-win8 
 *
 * 2014年10月16日 下午11:52:57
 * 
 * @功能
 * 			1. crud
 * 			2. 表联结
 */
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
		User u;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    u= (User) session.byId(User.class).load(user.getId());
	    if (u != null) {
	    	session.clear();
	    	session.update(user);
	    } else {
	    	session.save(user);
	    }
		session.getTransaction().commit();
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
