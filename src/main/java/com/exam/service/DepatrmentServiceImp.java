package com.exam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.DepartmentDao;
import com.exam.model.Depatrment;
@Service
@Transactional
public class DepatrmentServiceImp implements DepartmentService {
	
	@Autowired
    DepartmentDao departmentDao;
	@Override
	public Depatrment saveDepartment(Depatrment depatrment) {
		return departmentDao.saveDepartment(depatrment);
		
	}

	@Override
	public Depatrment update(Depatrment depatrment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Depatrment> getAll() {
		
		return departmentDao.getAll();
	}

	@Override
	public Depatrment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
