package com.exam.dao.project;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.CreatProject;

@Repository
public class CreatProjectDaoImp implements CreatProjectDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public CreatProject saveCreatProject(CreatProject creatProject) {
		try {
			sessionFactory.getCurrentSession().save(creatProject);
			return (creatProject) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public CreatProject update(CreatProject creatProject) {
		try {
			sessionFactory.getCurrentSession().update(creatProject);
			return (creatProject) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			CreatProject entity = sessionFactory.getCurrentSession().get(CreatProject.class, id);
			sessionFactory.getCurrentSession().delete(entity);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<CreatProject> getAll() {
		try {
			List<CreatProject> projectList = (List<CreatProject>) sessionFactory.getCurrentSession().createQuery("FROM CreatProject").setFetchSize(50).list();
			return projectList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public CreatProject getById(int id) {
		try {
			CreatProject entity = sessionFactory.getCurrentSession().get(CreatProject.class, id);
			return entity;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<CreatProject> getSerch(String serch) {
		try {
			List<CreatProject>  networking = (List<CreatProject>) sessionFactory.getCurrentSession().createQuery("FROM CreatProject where ProjectManager=:ProjectManager or clientName=:clientName or projectType=:projectType or projectName=:projectName")
					.setParameter("ProjectManager", serch)
					.setParameter("clientName", serch)
					.setParameter("projectType", serch)
					.setParameter("projectName", serch)
					.setFetchSize(50).list();
			       return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

}
