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
		user.setAge(12);
		user.setName("管理用户");
		ctx.getBean(UserDao.class).save(user);
	}

	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<User>();
		users = ctx.getBean(UserDao.class).findAll();
		for (User u : users) {
			System.out.println("用户名：" + u.getName() + "&" + "年龄：" + u.getAge());
		}
	}

}
