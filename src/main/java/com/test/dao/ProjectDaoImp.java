package com.test.dao;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.entity.Project;

@Repository
public class ProjectDaoImp implements ProjectDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Project> findAllProjects() {
		Session session =sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Project> projects = session.createQuery("from Project").list();
		session.getTransaction().commit();
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
