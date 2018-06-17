package com.egiants.rlm.service;

import java.util.List;

import com.egiants.rlm.entity.Education;

public interface EducationService {

	List<Education> getUsers();

	Education getUser(String emailId);

	Education createUser(Education user);

	Education createOrUpdateUser(Education user);

	void deleteUser(String emailId);

}
