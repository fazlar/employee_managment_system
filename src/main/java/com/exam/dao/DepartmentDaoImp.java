package com.exam.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.Depatrment;
import com.exam.model.Employee;
@Repository
public class DepartmentDaoImp implements DepartmentDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Depatrment saveDepartment(Depatrment depatrment) {
		try {
			sessionFactory.getCurrentSession().save(depatrment);
			return (depatrment) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Depatrment update(Depatrment depatrment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Depatrment> getAll() {
		try {
			
			List<Depatrment> depatrmentList = (List<Depatrment>) sessionFactory.getCurrentSession().createQuery("FROM Depatrment").setFetchSize(50).list();
			return depatrmentList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Depatrment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
