package com.egiants.rlm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.entity.UserDemoGraphic;

@Service
public class UserDemoGraphicServiceImpl implements UserDemoGraphicService {

	@Autowired
	private UserDemoGraphicDao UserDemoGraphicDao;

	@Override
	public List<UserDemoGraphic> getUsers() {
		return this.UserDemoGraphicDao.getUsers();
	}

	@Override
	public UserDemoGraphic getUser(String emailId) {
		return this.UserDemoGraphicDao.getUser(emailId);
	}

	@Override
	public UserDemoGraphic createUser(UserDemoGraphic user) {
		return this.UserDemoGraphicDao.createUser(user);
	}

	@Override
	public UserDemoGraphic createOrUpdateUser(UserDemoGraphic user) {
		return this.UserDemoGraphicDao.createOrUpdateUser(user);
	}

	@Override
	public void deleteUser(String emailId) {
		this.UserDemoGraphicDao.deleteUser(emailId);
	}

}
