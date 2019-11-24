package com.exam.dao.leave;

import java.util.List;

import com.exam.model.ApplyLeave;

public interface ApplyLeaveDao {
	public ApplyLeave saveLeave(ApplyLeave applyLeave);
    public ApplyLeave update(ApplyLeave applyLeave);
    public boolean delete(int id);
    public List<ApplyLeave> getAll();
    public ApplyLeave getById(int id);
    public void updateStatus(int id);
}
