package com.exam.service;

import java.util.List;

import com.exam.model.Depatrment;

public interface DepartmentService {
	public Depatrment saveDepartment(Depatrment depatrment);
    public Depatrment update(Depatrment depatrment);
      public boolean delete(int id);
    public List<Depatrment> getAll();
    public Depatrment getById(int id);
}
