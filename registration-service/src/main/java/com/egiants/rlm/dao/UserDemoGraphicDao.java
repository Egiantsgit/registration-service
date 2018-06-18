package com.egiants.rlm.dao;

import java.util.List;

import com.egiants.rlm.entity.UserDemoGraphic;

public interface UserDemoGraphicDao {

	List<UserDemoGraphic> getUsers();

	UserDemoGraphic getUser(String emailId);

	UserDemoGraphic createUser(UserDemoGraphic user);

	UserDemoGraphic createOrUpdateUser(UserDemoGraphic user);

	void deleteUser(String emailId);
}
