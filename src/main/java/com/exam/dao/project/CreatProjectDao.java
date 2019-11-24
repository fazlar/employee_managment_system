package com.exam.dao.project;

import java.util.List;

import com.exam.model.CreatProject;
import com.exam.model.Employee;

public interface CreatProjectDao {
	public CreatProject saveCreatProject(CreatProject creatProject);
    public CreatProject update(CreatProject creatProject);
    public boolean delete(int id);
    public List<CreatProject> getAll();
    public CreatProject getById(int id);
    public List<CreatProject> getSerch(String serch);
}
