package com.exam.dao.assinproject;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.AssignProject;
import com.exam.model.Salary;
import com.exam.model.Schedul;
@Repository
public class AssignProjectDaoImp implements AssignProjectDao {
	@Autowired
    SessionFactory sessionFactory;

	@Override
	public AssignProject saveAssignProject(AssignProject assignProject) {
		try {
			sessionFactory.getCurrentSession().save(assignProject);
			return (assignProject) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public AssignProject update(AssignProject assignProject) {
		try {
			sessionFactory.getCurrentSession().update(assignProject);
			return (assignProject) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			AssignProject assignProject = sessionFactory.getCurrentSession().get(AssignProject.class, id);
			sessionFactory.getCurrentSession().delete(assignProject);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<AssignProject> getAll() {
		try {
			List<AssignProject> assignProjectList = (List<AssignProject>) sessionFactory.getCurrentSession().createQuery("FROM AssignProject").setFetchSize(50).list();
			return assignProjectList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public AssignProject getById(int id) {
		try {
			AssignProject assignProject = sessionFactory.getCurrentSession().get(AssignProject.class, id);
			return assignProject;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<AssignProject> getProjectByUsername(String userName) {
		try {
			List<AssignProject> assignProject = (List<AssignProject>) sessionFactory.getCurrentSession().createQuery("FROM AssignProject where userName=:userName")
		    .setParameter("userName", userName)
			.setFetchSize(50).list();
			return assignProject;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public void updateStatus(int id) {
		try {
			AssignProject assignProject = sessionFactory.getCurrentSession().get(AssignProject.class, id);
			assignProject.setStatus("complete");
			sessionFactory.getCurrentSession().update(assignProject);
			 //sessionFactory.getCurrentSession().createQuery("update AssignProject set status='complete' where id=:id")
					//.setParameter("id", id);
			
		} catch (HibernateException e) {
			
		}
	}

	@Override
	public List<AssignProject> getSerch(String serch) {
		try {
			List<AssignProject>  networking = (List<AssignProject>) sessionFactory.getCurrentSession().createQuery("FROM AssignProject where empName=:empName or projectName=:projectName or status=:status")
					.setParameter("empName", serch)
					.setParameter("projectName", serch)
					.setParameter("status", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<AssignProject> getSerchMyschedul(String userName, String serch) {
		try {
			List<AssignProject>  networking = (List<AssignProject>) sessionFactory.getCurrentSession().createQuery("FROM AssignProject where userName=:userName and (empName=:empName or projectName=:projectName or status=:status)")
					.setParameter("userName", userName)
					.setParameter("empName", serch)
					.setParameter("projectName", serch)
					.setParameter("status", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

}
