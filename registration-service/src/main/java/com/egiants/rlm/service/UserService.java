package com.egiants.rlm.service;

import java.util.List;

import com.egiants.rlm.entity.User;


public interface UserService {
	
	List<User> getUsers();
	
	User getUser(String emailId);
	
	User createUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(String emailId);

}
