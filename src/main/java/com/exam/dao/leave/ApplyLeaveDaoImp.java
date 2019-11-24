package com.exam.dao.leave;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.ApplyLeave;
import com.exam.model.AssignProject;
import com.exam.model.Employee;
@Repository
public class ApplyLeaveDaoImp implements ApplyLeaveDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public ApplyLeave saveLeave(ApplyLeave applyLeave) {
		try {
			sessionFactory.getCurrentSession().save(applyLeave);
			return (applyLeave) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public ApplyLeave update(ApplyLeave applyLeave) {
		try {
			sessionFactory.getCurrentSession().update(applyLeave);
			return (applyLeave) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			ApplyLeave applyLeave = sessionFactory.getCurrentSession().get(ApplyLeave.class, id);
			sessionFactory.getCurrentSession().delete(applyLeave);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<ApplyLeave> getAll() {
		try {
			List<ApplyLeave> applyLeaveList = (List<ApplyLeave>) sessionFactory.getCurrentSession().createQuery("FROM ApplyLeave").setFetchSize(50).list();
			return applyLeaveList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public ApplyLeave getById(int id) {
		try {
			ApplyLeave applyLeave = sessionFactory.getCurrentSession().get(ApplyLeave.class, id);
			return applyLeave;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public void updateStatus(int id) {
		try {
			ApplyLeave applyLeave = sessionFactory.getCurrentSession().get(ApplyLeave.class, id);
			applyLeave.setStatus("Approve");
			sessionFactory.getCurrentSession().update(applyLeave);
			 //sessionFactory.getCurrentSession().createQuery("update AssignProject set status='complete' where id=:id")
					//.setParameter("id", id);
			
		} catch (HibernateException e) {
			
		}
		
	}

}
