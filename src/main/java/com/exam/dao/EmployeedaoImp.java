package com.exam.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.Employee;
import com.exam.model.Joptype;
@Repository
public class EmployeedaoImp implements EmployeeDao{
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Employee saveEmployee(Employee empolyee) {
		try {
			sessionFactory.getCurrentSession().save(empolyee);
			return (empolyee) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Employee update(Employee empolyee) {
		try {
			sessionFactory.getCurrentSession().update(empolyee);
			return (empolyee) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			Employee empolyee = sessionFactory.getCurrentSession().get(Employee.class, id);
			sessionFactory.getCurrentSession().delete(empolyee);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<Employee> getAll() {
		try {
			List<Employee> empolyeeList = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee").setFetchSize(50).list();
			return empolyeeList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Employee getById(int id) {
		try {
			Employee empolyee = sessionFactory.getCurrentSession().get(Employee.class, id);
			return empolyee;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllProjectManager() {
		try {
			List<Employee> projectmanager = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where jobtype='Project Manager'").setFetchSize(50).list();
			return projectmanager;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllAdminDepart() {
		try {
			List<Employee>  adminstration = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='ADMINISTRATION'").setFetchSize(50).list();
			return adminstration;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllWebDepart() {
		try {
			List<Employee>  web = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='WEB DEVELOPMENT'").setFetchSize(50).list();
			return web;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllDatabaseDepart() {
		try {
			List<Employee>  database = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='DATABASE DESIGNE'").setFetchSize(50).list();
			return database;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllNtDepart() {
		try {
			List<Employee>  networking = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='NET WORKING'").setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllHRDepart() {
		try {
			List<Employee>  networking = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='HR DEPARTMENT'").setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllFinanceDepart() {
		try {
			List<Employee>  networking = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='FINANCE'").setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	
	}

	@Override
	public List<Employee> getEmpForProjec() {
		try {
			List<Employee>  networking = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where department='WEB DEVELOPMENT' or department='DATABASE DESIGNE' or department='NET WORKING' ").setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	
	}

	@Override
	public List<Employee> getSerch(String serch) {
		try {
			List<Employee>  networking = (List<Employee>) sessionFactory.getCurrentSession().createQuery("FROM Employee where fullname=:serch or department=:dep or country=:country or city=:city or jobtype=:jobtype ")
					.setParameter("serch", serch)
					.setParameter("dep", serch)
					.setParameter("country", serch)
					.setParameter("city", serch)
					.setParameter("jobtype", serch)
					.setFetchSize(50).list();
			return networking;
		} catch (HibernateException e) {
			return null;
		}
	}
}
