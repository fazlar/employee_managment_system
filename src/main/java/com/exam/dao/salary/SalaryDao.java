package com.exam.dao.salary;

import java.util.List;

import com.exam.model.AssignProject;
import com.exam.model.Salary;;

public interface SalaryDao {
	public Salary saveSalary(Salary salary);
    public Salary update(Salary salary);
    public boolean delete(int id);
    public List<Salary> getAll();
    public Salary getById(int id);
    public List<Salary> getSalaryByUsername(String userName);
    public List<Salary> getSerch(String serch);
    public List<Salary> getSerchMySalary(String userName,String serch);
}
