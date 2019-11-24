package com.exam.dao.schedule;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.Schedul;
import com.exam.model.Employee;
import com.exam.model.Salary;
@Repository
public class SchedualDaoImp implements SchedualDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Schedul saveSchedul(Schedul schedul) {
		try {
			sessionFactory.getCurrentSession().save(schedul);
			return (schedul) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Schedul update(Schedul schedul) {
		try {
			sessionFactory.getCurrentSession().update(schedul);
			return (schedul) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			Schedul schedul = sessionFactory.getCurrentSession().get(Schedul.class, id);
			sessionFactory.getCurrentSession().delete(schedul);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<Schedul> getAll() {
		try {
			List<Schedul> schedulList = (List<Schedul>) sessionFactory.getCurrentSession().createQuery("FROM Schedul").setFetchSize(50).list();
			return schedulList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Schedul getById(int id) {
		try {
			Schedul entity = sessionFactory.getCurrentSession().get(Schedul.class, id);
			return entity;
		} catch (HibernateException e) {
			return null;
		}
	}
	@Override
	public List<Schedul> getSchedulByUsername(String userName) {
		try {
			List<Schedul> schedul = (List<Schedul>) sessionFactory.getCurrentSession().createQuery("FROM Schedul where userName=:userName")
		    .setParameter("userName", userName)
			.setFetchSize(50).list();
			return schedul;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Schedul> getSerch(String serch) {
		try {
			List<Schedul>  networking = (List<Schedul>) sessionFactory.getCurrentSession().createQuery("FROM Schedul where empName=:empName or clientName=:clientName or status=:status")
					.setParameter("empName", serch)
					.setParameter("clientName", serch)
					.setParameter("status", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Schedul> getSerchMyschedul( String userName,String serch) {
		try {
			List<Schedul>  networking = (List<Schedul>) sessionFactory.getCurrentSession().createQuery("FROM Schedul where userName=:userName and (empName=:empName or clientName=:clientName or status=:status)")
					.setParameter("userName", userName)
					.setParameter("empName", serch)
					.setParameter("clientName", serch)
					.setParameter("status", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

}
