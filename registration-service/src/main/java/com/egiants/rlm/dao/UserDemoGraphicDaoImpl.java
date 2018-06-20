package com.egiants.rlm.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.dao.config.DynamoDbConfig;
import com.egiants.rlm.entity.UserDemoGraphic;

@Repository
public class UserDemoGraphicDaoImpl implements UserDemoGraphicDao {

	@Autowired
	private UserDemoGraphicRepository UserDemoGraphicRepository;
	
	@Autowired
	DynamoDbConfig dynamoDbConfig;
	

	@Override
	public List<UserDemoGraphic> getUsersDemoGraphics() {
		// TODO Auto-generated method stub
		Iterable<UserDemoGraphic> users = this.UserDemoGraphicRepository.findAll();

		return (List<UserDemoGraphic>) users;
	}

	@Override
	public UserDemoGraphic getUserDemoGraphicInfo(UUID uuid) {
		// TODO: add Resource not found exception if user is null
		return this.UserDemoGraphicRepository.findOne(uuid);
	}

	@Override
	public UserDemoGraphic createUserDemoGraphicInfo(UserDemoGraphic user) {

		// TODO implement only for create
		return this.UserDemoGraphicRepository.save(user);
	}

	@Override
	public UserDemoGraphic updateUserDemoGraphicInfo(UserDemoGraphic user) {

		return this.UserDemoGraphicRepository.save(user);
	}

	@Override
	public void deleteUserDemoGraphicInfo(UUID uuid) {

		this.UserDemoGraphicRepository.delete(uuid);
	}

}
