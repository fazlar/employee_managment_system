package com.exam.service.project;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.UserInfoDao;
import com.exam.dao.project.CreatProjectDao;
import com.exam.model.CreatProject;
@Service
@Transactional
public class CreatProjectServiceImp implements CreatProjectService {
	@Autowired
    CreatProjectDao creatProjectDao;

	@Override
	public CreatProject saveCreatProject(CreatProject creatProject) {
		
		return creatProjectDao.saveCreatProject(creatProject);
	}

	@Override
	public CreatProject update(CreatProject creatProject) {
		
		return creatProjectDao.update(creatProject);
	}

	@Override
	public boolean delete(int id) {
		
		return creatProjectDao.delete(id);
	}

	@Override
	public List<CreatProject> getAll() {
		
		return creatProjectDao.getAll();
	}

	@Override
	public CreatProject getById(int id) {
		
		return creatProjectDao.getById(id);
	}

	@Override
	public List<CreatProject> getSerch(String serch) {
		// TODO Auto-generated method stub
		return creatProjectDao.getSerch(serch);
	}

}
