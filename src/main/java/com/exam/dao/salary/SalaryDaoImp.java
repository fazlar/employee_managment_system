package com.exam.dao.salary;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.Salary;
import com.exam.model.Schedul;
@Repository
public class SalaryDaoImp implements SalaryDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Salary saveSalary(Salary salary) {
		try {
			sessionFactory.getCurrentSession().save(salary);
			return (salary) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Salary update(Salary salary) {
		try {
			sessionFactory.getCurrentSession().update(salary);
			return (salary) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			Salary entity = sessionFactory.getCurrentSession().get(Salary.class, id);
			sessionFactory.getCurrentSession().delete(entity);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<Salary> getAll() {
		try {
			List<Salary> projectList = (List<Salary>) sessionFactory.getCurrentSession().createQuery("FROM Salary").setFetchSize(50).list();
			return projectList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Salary getById(int id) {
		try {
			Salary entity = sessionFactory.getCurrentSession().get(Salary.class, id);
			return entity;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Salary> getSalaryByUsername(String userName) {
		try {
			List<Salary> salary = (List<Salary>) sessionFactory.getCurrentSession().createQuery("FROM Salary where userName=:userName")
		    .setParameter("userName", userName)
			.setFetchSize(50).list();
			return salary;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Salary> getSerch(String serch) {
		try {
			List<Salary>  networking = (List<Salary>) sessionFactory.getCurrentSession().createQuery("FROM Salary where empName=:empName or month=:month or year=:year")
					.setParameter("empName", serch)
					.setParameter("month", serch)
					.setParameter("year", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Salary> getSerchMySalary(String userName, String serch) {
		try {
			List<Salary>  networking = (List<Salary>) sessionFactory.getCurrentSession().createQuery("FROM Salary where userName=:userName and (empName=:empName or month=:month or year=:year)")
					.setParameter("userName", userName)
					.setParameter("empName", serch)
					.setParameter("month", serch)
					.setParameter("year", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

}
