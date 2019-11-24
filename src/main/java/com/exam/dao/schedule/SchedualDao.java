package com.exam.dao.schedule;

import java.util.List;

import com.exam.model.Depatrment;
import com.exam.model.Employee;
import com.exam.model.Salary;
import com.exam.model.Schedul;

public interface SchedualDao {
	public Schedul saveSchedul(Schedul schedul);
    public Schedul update(Schedul schedul);
    public boolean delete(int id);
    public List<Schedul> getAll();
    public Schedul getById(int id);
    public List<Schedul> getSchedulByUsername(String userName);
    public List<Schedul> getSerch(String serch);
    public List<Schedul> getSerchMyschedul(String userName,String serch);
}
