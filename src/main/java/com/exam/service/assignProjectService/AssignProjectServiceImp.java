package com.exam.service.assignProjectService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.assinproject.AssignProjectDao;
import com.exam.model.AssignProject;
@Service
@Transactional
public class AssignProjectServiceImp implements AssignProjectService {
     @Autowired
     AssignProjectDao  assignProjectDao;
	@Override
	public AssignProject saveAssignProject(AssignProject assignProject) {
		
		return assignProjectDao.saveAssignProject(assignProject);
	}

	@Override
	public AssignProject update(AssignProject assignProject) {
		// TODO Auto-generated method stub
		return assignProjectDao.update(assignProject);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return assignProjectDao.delete(id);
	}

	@Override
	public List<AssignProject> getAll() {
		// TODO Auto-generated method stub
		return assignProjectDao.getAll();
	}

	@Override
	public AssignProject getById(int id) {
		// TODO Auto-generated method stub
		return assignProjectDao.getById(id);
	}

	@Override
	public List<AssignProject> getProjectByUsername(String userName) {
		// TODO Auto-generated method stub
		return assignProjectDao.getProjectByUsername(userName);
	}

	@Override
	public void updateStatus(int id) {
		
		assignProjectDao.updateStatus(id);
	}

	@Override
	public List<AssignProject> getSerch(String serch) {
		// TODO Auto-generated method stub
		return assignProjectDao.getSerch(serch);
	}

	@Override
	public List<AssignProject> getSerchMyschedul(String userName, String serch) {
		// TODO Auto-generated method stub
		return assignProjectDao.getSerchMyschedul(userName, serch);
	}

}
