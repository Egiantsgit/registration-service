package com.egiants.rlm.dao;

import java.util.List;

import com.egiants.rlm.entity.UserImmigrationDetails;

public interface UserImmigrationDetailsDao {
	
	List<UserImmigrationDetails> getAllUserImmigrationDetails();
	
	UserImmigrationDetails getUserImmigrationDetails(String uuid);
	
	UserImmigrationDetails createUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails);
	
	UserImmigrationDetails createOrUpdateUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails);
	
	void deleteUserImmigrationDetails(String uuid);

}
