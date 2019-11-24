package com.exam.dao.jobtype;

import java.util.List;

import com.exam.model.Depatrment;
import com.exam.model.Joptype;

public interface JobtypeDao {
	public Joptype saveJobtype(Joptype joptype);
    public Joptype update(Joptype joptype);
    public boolean delete(int id);
    public List<Joptype> getAll();
    public Joptype getById(int id);
    public List<Joptype> getAllProjectManager();
}
