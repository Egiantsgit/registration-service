package com.egiants.rlm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.egiants.rlm.dao.UserImmigrationDetailsDao;
import com.egiants.rlm.entity.UserImmigrationDetails;

@Service
public class UserImmigrationDetailsServiceImpl implements UserImmigrationDetailsService {
	
	@Autowired
	UserImmigrationDetailsDao userImmigrationDetailsDao;
	

	@Override
	public List<UserImmigrationDetails> getAllUserImmigrationDetails() {
		// TODO Auto-generated method stub
		return userImmigrationDetailsDao.getAllUserImmigrationDetails();
	}

	@Override
	public UserImmigrationDetails getUserImmigrationDetails(String uuid) {
		// TODO Auto-generated method stub
		return userImmigrationDetailsDao.getUserImmigrationDetails(uuid);
	}

	@Override
	public UserImmigrationDetails createUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
		// TODO Auto-generated method stub
		UUID id = UUID.randomUUID();
		userImmigrationDetails.setUuid(id.toString());
		return userImmigrationDetailsDao.createUserImmigrationDetails(userImmigrationDetails);
	}

	@Override
	public UserImmigrationDetails createOrUpdateUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
		// TODO Auto-generated method stub
		return userImmigrationDetailsDao.createOrUpdateUserImmigrationDetails(userImmigrationDetails);
	}

	@Override
	public void deleteUserImmigrationDetails(String uuid) {
		// TODO Auto-generated method stub
			userImmigrationDetailsDao.deleteUserImmigrationDetails(uuid);
	}

}
