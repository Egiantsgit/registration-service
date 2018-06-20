package com.egiants.rlm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.entity.UserImmigrationDetails;

@Repository
public class UserImmigrationDetailsDaoImpl implements UserImmigrationDetailsDao {
	
	@Autowired
	UserImmigrationDetailsRepository userImmigrationDetailsRepository;

	@Override
	public List<UserImmigrationDetails> getAllUserImmigrationDetails() {
			return (List<UserImmigrationDetails>) userImmigrationDetailsRepository.findAll();
	}

	@Override
	public UserImmigrationDetails getUserImmigrationDetails(String uuid) {
		// TODO Auto-generated method stub
		return userImmigrationDetailsRepository.findOne(uuid);
	}

	@Override
	public UserImmigrationDetails createUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
		// TODO Auto-generated method stub
		return userImmigrationDetailsRepository.save(userImmigrationDetails);
	}

	@Override
	public UserImmigrationDetails createOrUpdateUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
		// TODO Auto-generated method stub
		return userImmigrationDetailsRepository.save(userImmigrationDetails);
	}

	@Override
	public void deleteUserImmigrationDetails(String uuid) {
		// TODO Auto-generated method stub
		userImmigrationDetailsRepository.delete(uuid);
	}

}
