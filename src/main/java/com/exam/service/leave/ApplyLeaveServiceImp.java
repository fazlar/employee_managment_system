package com.exam.service.leave;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.leave.ApplyLeaveDao;
import com.exam.model.ApplyLeave;
@Service
@Transactional
public class ApplyLeaveServiceImp implements ApplyLeaveService {
	@Autowired
	ApplyLeaveDao applyLeaveDao;
	@Override
	public ApplyLeave saveLeave(ApplyLeave applyLeave) {
		// TODO Auto-generated method stub
		return applyLeaveDao.saveLeave(applyLeave);
	}

	@Override
	public ApplyLeave update(ApplyLeave applyLeave) {
		// TODO Auto-generated method stub
		return applyLeaveDao.update(applyLeave);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return applyLeaveDao.delete(id);
	}

	@Override
	public List<ApplyLeave> getAll() {
		// TODO Auto-generated method stub
		return applyLeaveDao.getAll();
	}

	@Override
	public ApplyLeave getById(int id) {
		// TODO Auto-generated method stub
		return applyLeaveDao.getById(id);
	}

	@Override
	public void updateStatus(int id) {
		// TODO Auto-generated method stub
		applyLeaveDao.updateStatus(id);
	}

}
