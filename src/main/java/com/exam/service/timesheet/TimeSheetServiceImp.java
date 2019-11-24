package com.exam.service.timesheet;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.exam.dao.timesheet.TimeSheetDao;
import com.exam.model.Salary;
import com.exam.model.TimeSheet;
@Service
@Transactional
public class TimeSheetServiceImp implements TimeSheetService {
   @Autowired
    TimeSheetDao timeSheetDao;
	@Override
	public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
		
		return timeSheetDao.saveTimeSheet(timeSheet);
	}

	@Override
	public TimeSheet update(TimeSheet timeSheet) {
		
		return timeSheetDao.update(timeSheet);
	}

	@Override
	public boolean delete(int id) {
		
		return timeSheetDao.delete(id);
	}

	@Override
	public List<TimeSheet> getAll() {
		
		return timeSheetDao.getAll();
	}

	@Override
	public TimeSheet getById(int id) {
		
		return timeSheetDao.getById(id);
	}

	@Override
	public List<TimeSheet> getTimesheetByUsername(String userName) {
		// TODO Auto-generated method stub
		return timeSheetDao.getTimesheetByUsername(userName);
	}

	@Override
	public void updateStatus(int id) {
		timeSheetDao.updateStatus(id);
		
	}

	@Override
	public List<TimeSheet> getSerch(String serch) {
		// TODO Auto-generated method stub
		return timeSheetDao.getSerch(serch);
	}

	@Override
	public List<TimeSheet> getSerchMyschedul(String userName, String serch) {
		// TODO Auto-generated method stub
		return timeSheetDao.getSerchMyschedul(userName, serch);
	}

}
