package com.exam.dao.attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.model.AssignProject;
import com.exam.model.Attendance;
import com.exam.model.Depatrment;
import com.exam.model.Salary;
@Repository
public class AttendanceDaoImp implements AttendanceDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public Attendance saveAttendance(Attendance attendance) {
		try {
			sessionFactory.getCurrentSession().save(attendance);
			return (attendance) ;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Attendance update(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Attendance> getAll() {
		try {
		 LocalDate date =java.time.LocalDate.now();
			List<Attendance> depatrmentList = (List<Attendance>) sessionFactory.getCurrentSession().createQuery("FROM Attendance where date=:date")
					.setParameter("date", date).setFetchSize(50).list();
			return depatrmentList;
		} catch (HibernateException e) {
			return null;
		}
	}

	@Override
	public Salary getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> getAttendanceByUsername(String userName,LocalDate date) {
		try {
			List<Attendance> attendance = (List<Attendance>) sessionFactory.getCurrentSession().createQuery("FROM Attendance where userName=:userName and date=:date")
		    .setParameter("userName", userName)
		    . setParameter("date", date)
			.setFetchSize(50).list();
			return attendance;
		} catch (HibernateException e) {
			return null;
		}
	}

}
