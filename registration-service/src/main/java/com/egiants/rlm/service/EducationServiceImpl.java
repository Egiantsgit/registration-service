package com.egiants.rlm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.rlm.dao.EducationDao;
import com.egiants.rlm.entity.Education;

@Service
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationDao educationDao;

	@Override
	public List<Education> getUsers() {
		return this.educationDao.getUsers();
	}

	@Override
	public Education getUser(String emailId) {
		return this.educationDao.getUser(emailId);
	}

	@Override
	public Education createUser(Education user) {
		return this.educationDao.createUser(user);
	}

	@Override
	public Education createOrUpdateUser(Education user) {
		return this.educationDao.createOrUpdateUser(user);
	}

	@Override
	public void deleteUser(String emailId) {
		this.educationDao.deleteUser(emailId);
	}

}
