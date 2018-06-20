package com.egiants.rlm.dao;

import java.util.List;
import java.util.UUID;

import com.egiants.rlm.entity.UserDemoGraphic;

public interface UserDemoGraphicDao {

	List<UserDemoGraphic> getUsersDemoGraphics();

	UserDemoGraphic getUserDemoGraphicInfo(UUID uuid);

	UserDemoGraphic createUserDemoGraphicInfo(UserDemoGraphic user);

	UserDemoGraphic updateUserDemoGraphicInfo(UserDemoGraphic user);

	void deleteUserDemoGraphicInfo(UUID uuid);
}
