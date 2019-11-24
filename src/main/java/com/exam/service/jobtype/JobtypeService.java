package com.exam.service.jobtype;

import java.util.List;

import com.exam.model.Joptype;

public interface JobtypeService {
	public Joptype saveJobtype(Joptype joptype);
    public Joptype update(Joptype joptype);
    public boolean delete(int id);
    public List<Joptype> getAll();
    public Joptype getById(int id);
    public List<Joptype> getAllProjectManager();
}
