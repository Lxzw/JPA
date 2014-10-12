package com.test.dao;

import java.util.ArrayList;
import java.util.List;








import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moke.jpa.util.Page;
import com.test.entity.Project;

@Repository
public class ProjectDaoImp implements ProjectDao {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Project> findAllProjects(Page<Project> page) {
		Session session =sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Project> projects = new ArrayList<Project>(); 
		projects = session.createQuery("from Project")
			.setFirstResult((int) (page.getCurrentPage() * page.getPageSize()))
			.setMaxResults((int) page.getPageSize())
			.list();
		session.getTransaction().commit();
		logger.info("11");
		logger.debug("debug");
		logger.warn("warn");
		logger.error("error");
		logger.trace("trace");
		System.err.println(22);
		return projects;
	}
	public Project findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Project project = (Project) session.get(Project.class, id);
		session.getTransaction().commit();
		return project;
	}

	public void saveOrUpdate(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		if (project.getId() == null || (session.load(Project.class, project.getId()) == null)) {
			session.save(project);
		} else {
			session.update(project);
		}
		session.getTransaction().commit();
	}

	public void delete(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(project);
		session.getTransaction().commit();
	}

}
