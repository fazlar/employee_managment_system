package com.exam.service.schedule;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.schedule.SchedualDao;
import com.exam.model.Salary;
import com.exam.model.Schedul;
@Service
@Transactional
public class SchedualServiceImp implements SchedulService {
    @Autowired
    SchedualDao schedualDao;
	@Override
	public Schedul saveSchedul(Schedul schedul) {
		
		 return schedualDao.saveSchedul(schedul);
	}

	@Override
	public Schedul update(Schedul schedul) {
		// TODO Auto-generated method stub
		return schedualDao.update(schedul);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return schedualDao.delete(id);
	}

	@Override
	public List<Schedul> getAll() {
		// TODO Auto-generated method stub
		return schedualDao.getAll();
	}

	@Override
	public Schedul getById(int id) {
		// TODO Auto-generated method stub
		return schedualDao.getById(id);
	}

	@Override
	public List<Schedul> getSalaryByUsername(String userName) {
		// TODO Auto-generated method stub
		return schedualDao.getSchedulByUsername(userName);
	}

	@Override
	public List<Schedul> getSerch(String serch) {
		// TODO Auto-generated method stub
		return schedualDao.getSerch(serch);
	}

	@Override
	public List<Schedul> getSerchMyschedul(String userName,String serch) {
		// TODO Auto-generated method stub
		return schedualDao.getSerchMyschedul(userName,serch);
	}

}
