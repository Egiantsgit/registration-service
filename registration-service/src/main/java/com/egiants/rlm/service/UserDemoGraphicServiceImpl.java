package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserDemoGraphic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDemoGraphicServiceImpl implements UserDemoGraphicService {

	@Autowired
	private UserDemoGraphicDao UserDemoGraphicDao;
	@Autowired
	private UserService userService;
	
	
	@Override
	public List<UserDemoGraphic> getUsersDemoGraphics() {
		return this.UserDemoGraphicDao.getUsersDemoGraphics();
	}

	@Override
	public UserDemoGraphic getUserDemoGraphicInfo(String emailId) {
		User user = this.userService.getUser(emailId);
		// if(user==null) {
		// // throw new Exception(); need to throw some custom exception
		// }
		return this.UserDemoGraphicDao.getUserDemoGraphicInfo(user.getUuid());
	}

	@Override
	public UserDemoGraphic createUserDemoGraphicInfo(UserDemoGraphic userDemoGraphic) {
		User user = this.userService.getUser(userDemoGraphic.getEmailId());
		if (user == null) {
			// throw new Exception(); need to throw some custom exception
		}
		// TODO: update userDemoGraphic model object with UUID
		userDemoGraphic.setUuid(user.getUuid());
		return this.UserDemoGraphicDao.createUserDemoGraphicInfo(userDemoGraphic);
	}

	@Override
	public UserDemoGraphic updateUserDemoGraphicInfo(UserDemoGraphic userDemoGraphic) {
		User user = this.userService.getUser(userDemoGraphic.getEmailId());

		userDemoGraphic.setUuid(user.getUuid());
		return this.UserDemoGraphicDao.updateUserDemoGraphicInfo(userDemoGraphic);
	}

	@Override
	public void deleteUserDemoGraphicInfo(String emailId) {
		User user = this.userService.getUser(emailId);
		// if(user==null) {
		// // throw new Exception(); need to throw some custom exception
		// }
		this.UserDemoGraphicDao.deleteUserDemoGraphicInfo(user.getUuid());
	}

}
