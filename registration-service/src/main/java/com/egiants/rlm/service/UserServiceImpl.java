package com.egiants.rlm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.rlm.dao.UserDao;
import com.egiants.rlm.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}

	@Override
	public User getUser(String emailId) {
		return this.userDao.getUser(emailId);
	}

	@Override
	public User createUser(User user) {
		UUID id = UUID.randomUUID();
		user.setUid(id);
		return this.userDao.createUser(user);
	}

	@Override
	public User createOrUpdateUser(User user) {
		return this.userDao.createOrUpdateUser(user);
	}

	@Override
	public void deleteUser(String emailId) {
		System.out.println(emailId);
		this.userDao.deleteUser(emailId);
	}

}
