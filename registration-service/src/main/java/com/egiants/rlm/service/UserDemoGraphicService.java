package com.egiants.rlm.service;

import java.util.List;

import com.egiants.rlm.entity.UserDemoGraphic;

public interface UserDemoGraphicService {

	List<UserDemoGraphic> getUsersDemoGraphics();

	UserDemoGraphic getUserDemoGraphicInfo(String emailId);

	UserDemoGraphic createUserDemoGraphicInfo(UserDemoGraphic user);

	UserDemoGraphic updateUserDemoGraphicInfo(UserDemoGraphic user);

	void deleteUserDemoGraphicInfo(String emailId);

}
