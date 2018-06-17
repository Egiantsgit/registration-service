package com.egiants.rlm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.entity.UserDemoGraphic;

@Repository
public class UserDemoGraphicDaoImpl implements UserDemoGraphicDao {

	@Autowired
	private UserDemoGraphicRepository UserDemoGraphicRepository;

	@Override
	public List<UserDemoGraphic> getUsers() {
		// TODO Auto-generated method stub
		Iterable<UserDemoGraphic> users = this.UserDemoGraphicRepository.findAll();

		return (List<UserDemoGraphic>) users;
	}

	@Override
	public UserDemoGraphic getUser(String emailId) {
		// TODO: add Resource not found exception if user is null
		return this.UserDemoGraphicRepository.findOne(emailId);
	}

	@Override
	public UserDemoGraphic createUser(UserDemoGraphic user) {

		// TODO implement only for create
		return this.UserDemoGraphicRepository.save(user);
	}

	@Override
	public UserDemoGraphic createOrUpdateUser(UserDemoGraphic user) {

		return this.UserDemoGraphicRepository.save(user);
	}

	@Override
	public void deleteUser(String emailId) {

		this.UserDemoGraphicRepository.delete(emailId);
	}

}
