package com.exam.service.salary;

import java.util.List;

import com.exam.dao.salary.SalaryDao;
import com.exam.model.Salary;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class SalaryServiceImp implements SalaryService {
	   @Autowired
	   SalaryDao salaryDao;
	@Override
	public Salary saveSalary(Salary salary) {
		
		return salaryDao.saveSalary(salary);
	}

	@Override
	public Salary update(Salary salary) {
		
		return salaryDao.update(salary);
	}

	@Override
	public boolean delete(int id) {
		
		return salaryDao.delete(id);
	}

	@Override
	public List<Salary> getAll() {
		
		return salaryDao.getAll();
	}

	@Override
	public Salary getById(int id) {
		
		return salaryDao.getById(id);
	}

	@Override
	public List<Salary> getSalaryByUsername(String userName) {
		
		return salaryDao.getSalaryByUsername(userName);
	}

	@Override
	public List<Salary> getSerch(String serch) {
		// TODO Auto-generated method stub
		return salaryDao.getSerch(serch);
	}

	@Override
	public List<Salary> getSerchMySalary(String userName, String serch) {
		// TODO Auto-generated method stub
		return salaryDao.getSerchMySalary(userName, serch);
	}

}
