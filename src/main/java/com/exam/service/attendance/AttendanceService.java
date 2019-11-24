package com.exam.service.attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.exam.model.Attendance;
import com.exam.model.Salary;

public interface AttendanceService {
	public Attendance saveAttendance(Attendance attendance);
    public Attendance update(Attendance attendance);
    public boolean delete(int id);
    public List<Attendance> getAll();
    public Salary getById(int id);
    public List<Attendance> getAttendanceByUsername(String userName,LocalDate date);
}
