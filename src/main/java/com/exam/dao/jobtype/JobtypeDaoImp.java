package com.exam.dao.jobtype;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.Depatrment;
import com.exam.model.Joptype;
@Repository
public class JobtypeDaoImp implements JobtypeDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Joptype saveJobtype(Joptype joptype) {
		try {
			sessionFactory.getCurrentSession().save(joptype);
			return (joptype) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Joptype update(Joptype joptype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Joptype> getAll() {
		try {
			List<Joptype> JoptypeList = (List<Joptype>) sessionFactory.getCurrentSession().createQuery("FROM Joptype").setFetchSize(50).list();
			return JoptypeList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Joptype getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Joptype> getAllProjectManager() {
		try {
			List<Joptype> projectmanager = (List<Joptype>) sessionFactory.getCurrentSession().createQuery("FROM Joptype where jobType='Project Manager'").setFetchSize(50).list();
			return projectmanager;
		} catch (HibernateException e) {
			return null;
		}
	}
     
}
