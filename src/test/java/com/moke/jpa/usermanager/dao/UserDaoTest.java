package com.moke.jpa.usermanager.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moke.jpa.usermanager.entity.User;

public class UserDaoTest {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	
	@Test
	public void testSave() {
		User user = new User();
		user.setAge(14);
		user.setName("超级管理用户");
		ctx.getBean(UserDao.class).save(user);
	}

	@Test
	public void testSaveOrUpdate() {
		User user = new User();
		user.setId(1L);
		user.setName("妈妈咪呀");
		user.setAge(44);
		ctx.getBean(UserDao.class).saveOrUpdate(user);
	}

	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<User>();
		users = (List<User>)ctx.getBean(UserDao.class).findAll();
		for (User u : users) {
			System.out.println("用户名：" + u.getName() + "&" + "年龄：" + u.getAge());
		}
	}
	
	@Test
	public void testFindById() {
		User u = ctx.getBean(UserDao.class).findById(1L);
		System.out.println("用户名：" + u.getName() + "&" + "年龄：" + u.getAge());
	}

}
