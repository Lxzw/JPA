package com.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.entity.Project;

public class ProjectDaoImpTest {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
	@Test
	public void testFindAllProjects() {
		ProjectDao projectDao = ctx.getBean(ProjectDaoImp.class);
		System.out.println(projectDao.findAllProjects().size());
	}

	@Test
	public void testFindById() {
		ProjectDao projectDao = ctx.getBean(ProjectDaoImp.class);
		try {
			System.out.println(projectDao.findById(2).getName());
		} catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage() + "数据库中不存在Id=2的项目！");
		}
	}

	@Test
	public void testSaveOrUpdate() {
		ProjectDao projectDao = ctx.getBean(ProjectDaoImp.class);
		Project p1 = new Project();
		p1.setName("你我");
		projectDao.saveOrUpdate(p1);
		Project p2 = new Project();
		p2.setName("Learning");
		projectDao.saveOrUpdate(p2);
	}
	
	@Test
	public void testDelete() {
		ProjectDao projectDao = ctx.getBean(ProjectDaoImp.class);
		Project project = new Project();
		project.setId(1);
		projectDao.delete(project);
	}

}
