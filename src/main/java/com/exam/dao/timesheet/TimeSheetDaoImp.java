package com.exam.dao.timesheet;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.AssignProject;
import com.exam.model.CreatProject;
import com.exam.model.Salary;
import com.exam.model.Schedul;
import com.exam.model.TimeSheet;
@Repository
public class TimeSheetDaoImp implements TimeSheetDao {
	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
		try {
			sessionFactory.getCurrentSession().save(timeSheet);
			return (timeSheet) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public TimeSheet update(TimeSheet timeSheet) {
		try {
			sessionFactory.getCurrentSession().update(timeSheet);
			return (timeSheet) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			TimeSheet entity = sessionFactory.getCurrentSession().get(TimeSheet.class, id);
			sessionFactory.getCurrentSession().delete(entity);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<TimeSheet> getAll() {
		try {
			List<TimeSheet> projectList = (List<TimeSheet>) sessionFactory.getCurrentSession().createQuery("FROM TimeSheet").setFetchSize(50).list();
			return projectList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public TimeSheet getById(int id) {
		try {
			TimeSheet entity = sessionFactory.getCurrentSession().get(TimeSheet.class, id);
			return entity;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public List<TimeSheet> getTimesheetByUsername(String userName) {
		try {
			List<TimeSheet> timeSheet = (List<TimeSheet>) sessionFactory.getCurrentSession().createQuery("FROM TimeSheet where userName=:userName")
		    .setParameter("userName", userName)
			.setFetchSize(50).list();
			return timeSheet;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public void updateStatus(int id) {
		try {
			TimeSheet timeSheet = sessionFactory.getCurrentSession().get(TimeSheet.class, id);
			timeSheet.setStatus("complete");
			sessionFactory.getCurrentSession().update(timeSheet);
			 //sessionFactory.getCurrentSession().createQuery("update AssignProject set status='complete' where id=:id")
					//.setParameter("id", id);
			
		} catch (HibernateException e) {
			
		}
		
	}

	@Override
	public List<TimeSheet> getSerch(String serch) {
		try {
			List<TimeSheet>  networking = (List<TimeSheet>) sessionFactory.getCurrentSession().createQuery("FROM TimeSheet where empName=:empName or projectName=:projectName or status=:status")
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
	public List<TimeSheet> getSerchMyschedul(String userName, String serch) {
		try {
			List<TimeSheet>  networking = (List<TimeSheet>) sessionFactory.getCurrentSession().createQuery("FROM TimeSheet where userName=:userName and (empName=:empName or projectName=:projectName or status=:status)")
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
