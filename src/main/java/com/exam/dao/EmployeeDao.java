package com.exam.dao;

import java.util.List;

import com.exam.model.Employee;
import com.exam.model.Joptype;

public interface EmployeeDao {
	public Employee saveEmployee(Employee empolyee);
    public Employee update(Employee empolyee);
    public boolean delete(int id);
    public List<Employee> getAll();
    public Employee getById(int id);
    public List<Employee> getAllProjectManager();
    public List<Employee> getEmpForProjec();
	public List<Employee> getAllAdminDepart();
	public List<Employee> getAllWebDepart();
	public List<Employee> getAllDatabaseDepart();
	public List<Employee> getAllNtDepart();
	public List<Employee> getAllHRDepart();
	public List<Employee> getAllFinanceDepart();
	 public List<Employee> getSerch(String serch);
	
}
