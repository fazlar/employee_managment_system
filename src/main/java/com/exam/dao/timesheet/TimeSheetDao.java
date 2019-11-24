package com.exam.dao.timesheet;

import java.util.List;

import com.exam.model.Salary;
import com.exam.model.Schedul;
import com.exam.model.TimeSheet;;

public interface TimeSheetDao {
	public TimeSheet saveTimeSheet(TimeSheet timeSheet);
    public TimeSheet update(TimeSheet timeSheet);
    public boolean delete(int id);
    public List<TimeSheet> getAll();
    public TimeSheet getById(int id);
    public List<TimeSheet> getTimesheetByUsername(String userName);
    public void updateStatus(int id);
    public List<TimeSheet> getSerch(String serch);
    public List<TimeSheet> getSerchMyschedul(String userName,String serch);
}
