package com.exam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.EmployeeDao;
import com.exam.model.Employee;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
  
	@Autowired
    EmployeeDao employeeDao;
	
	@Override
	public Employee saveEmployee(Employee empolyee) {
		return employeeDao.saveEmployee(empolyee);
		
	}

	@Override
	public Employee update(Employee empolyee) {
		// TODO Auto-generated method stub
		return employeeDao.update(empolyee);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return employeeDao.delete(id);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return  employeeDao.getAll();
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAllProjectManager() {
		return  employeeDao.getAllProjectManager();
	}

	@Override
	public List<Employee> getAllAdminDepart() {
		
		return employeeDao.getAllAdminDepart();
	}

	@Override
	public List<Employee> getAllWebDepart() {
		// TODO Auto-generated method stub
		return employeeDao.getAllWebDepart();
	}

	@Override
	public List<Employee> getAllDatabaseDepart() {
		// TODO Auto-generated method stub
		return employeeDao.getAllDatabaseDepart();
	}

	@Override
	public List<Employee> getAllNtDepart() {
		// TODO Auto-generated method stub
		return employeeDao.getAllNtDepart();
	}

	@Override
	public List<Employee> getAllHRDepart() {
		// TODO Auto-generated method stub
		return employeeDao.getAllHRDepart();
	}

	@Override
	public List<Employee> getAllFinanceDepart() {
		// TODO Auto-generated method stub
		return employeeDao.getAllFinanceDepart();
	}

	@Override
	public List<Employee> getEmpForProjec() {
		// TODO Auto-generated method stub
		return employeeDao.getEmpForProjec();
	}

	@Override
	public List<Employee> getSerch(String serch) {
		// TODO Auto-generated method stub
		return employeeDao.getSerch(serch);
	}

}
