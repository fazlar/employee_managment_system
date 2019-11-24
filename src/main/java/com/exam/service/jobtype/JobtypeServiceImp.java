package com.exam.service.jobtype;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.jobtype.JobtypeDao;
import com.exam.model.Joptype;
@Service
@Transactional
public class JobtypeServiceImp implements JobtypeService {
   @Autowired
   JobtypeDao jobtypeDao;
	
	@Override
	public Joptype saveJobtype(Joptype joptype) {
		
		return jobtypeDao.saveJobtype(joptype);
	}

	@Override
	public Joptype update(Joptype joptype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Joptype> getAll() {
		
		return jobtypeDao.getAll();
	}

	@Override
	public Joptype getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Joptype> getAllProjectManager() {
		
		return jobtypeDao.getAllProjectManager();
	}

}
