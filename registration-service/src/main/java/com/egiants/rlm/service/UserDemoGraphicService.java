package com.egiants.rlm.service;

import java.util.List;

import com.egiants.rlm.entity.UserDemoGraphic;

public interface UserDemoGraphicService {

	List<UserDemoGraphic> getUsers();

	UserDemoGraphic getUser(String emailId);

	UserDemoGraphic createUser(UserDemoGraphic user);

	UserDemoGraphic createOrUpdateUser(UserDemoGraphic user);

	void deleteUser(String emailId);

}
