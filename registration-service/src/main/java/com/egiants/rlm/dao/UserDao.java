package com.egiants.rlm.dao;

import java.util.List;

import com.egiants.rlm.entity.User;


public interface UserDao {
	
	List<User> getUsers();
	
	User getUser(String emailId);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(String emailId);
}
