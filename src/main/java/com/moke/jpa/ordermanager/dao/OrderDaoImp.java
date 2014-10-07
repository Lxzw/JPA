package com.moke.jpa.ordermanager.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moke.jpa.ordermanager.entity.Order;

@Repository
public class OrderDaoImp implements OrderDao {
	
	private Session session;
	
	@Autowired
	public OrderDaoImp(SessionFactory sessionFactory) {
		setSession(sessionFactory.getCurrentSession());
	}
	
	public Order getOrderById(Integer id) {
		String sql = "select * from order where id=" + id;
		session.beginTransaction();
		return null;
	}


	public List<Order> queryByAll() {
		return null;
	}

	public List<Order> queryByDealedTime(Order order) {
		return null;
	}

	public List<Order> queryByPaidTime(Order order) {
		return null;
	}

	public List<Order> queryByNeedPaidTime(Order order) {
		return null;
	}

	public void updateOrderOnAddrress(Order order) {
		
	}

	public void updateOrderOnPaidType(Order order) {
		
	}

	public void updateOrderOnArrivedDate(Order order) {
		
	}

	public void updateOrderOnChecksName(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void createAnOder(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
