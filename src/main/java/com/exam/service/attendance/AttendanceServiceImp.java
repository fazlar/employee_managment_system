package com.exam.service.attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.attendance.AttendanceDao;
import com.exam.model.Attendance;
import com.exam.model.Salary;
@Service
@Transactional
public class AttendanceServiceImp implements AttendanceService{
     @Autowired
     AttendanceDao attendanceDao;
	@Override
	public Attendance saveAttendance(Attendance attendance) {
		
		return attendanceDao.saveAttendance(attendance);
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
		// TODO Auto-generated method stub
		return attendanceDao.getAll();
	}

	@Override
	public Salary getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> getAttendanceByUsername(String userName,LocalDate date) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttendanceByUsername(userName, date);
	}

}
