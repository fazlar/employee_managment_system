package com.exam.service.schedule;

import java.util.List;

import com.exam.model.Salary;
import com.exam.model.Schedul;

public interface SchedulService {
	public Schedul saveSchedul(Schedul schedul);
    public Schedul update(Schedul schedul);
    public boolean delete(int id);
    public List<Schedul> getAll();
    public Schedul getById(int id);
    public List<Schedul> getSalaryByUsername(String userName);
    public List<Schedul> getSerch(String serch);
    public List<Schedul> getSerchMyschedul(String serch,String userName);
}
