package com.moke.jpa;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moke.jpa.ordermanager.entity.Order;

public class ApplicationTest {

	private ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
	@Test
	public void test() {
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		order.setUsername("xxx");
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
	}

}
