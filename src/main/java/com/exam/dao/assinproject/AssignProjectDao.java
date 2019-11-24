package com.exam.dao.assinproject;

import java.util.List;

import com.exam.model.AssignProject;
import com.exam.model.Employee;
import com.exam.model.Salary;
import com.exam.model.Schedul;

public interface AssignProjectDao {
	public AssignProject saveAssignProject(AssignProject assignProject);
    public AssignProject update(AssignProject assignProject);
    public boolean delete(int id);
    public List<AssignProject> getAll();
    public AssignProject getById(int id);
    public List<AssignProject> getProjectByUsername(String userName);
    public void updateStatus(int id);
    public List<AssignProject> getSerch(String serch);
    public List<AssignProject> getSerchMyschedul(String userName,String serch);
}
