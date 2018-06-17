package com.egiants.rlm.dao;

import java.util.List;

import com.egiants.rlm.entity.Education;

public interface EducationDao {

	List<Education> getUsers();

	Education getUser(String emailId);

	Education createUser(Education user);

	Education createOrUpdateUser(Education user);

	void deleteUser(String emailId);
}
