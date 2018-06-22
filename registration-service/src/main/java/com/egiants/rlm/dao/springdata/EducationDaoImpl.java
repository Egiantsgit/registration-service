package com.egiants.rlm.dao.springdata;

import java.util.List;

import com.egiants.rlm.dao.EducationDao;
import com.egiants.rlm.dao.springdata.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.entity.Education;

@Repository
public class EducationDaoImpl implements EducationDao {

	@Autowired
	private EducationRepository educationRepository;

	@Override
	public List<Education> getUsers() {
		// TODO Auto-generated method stub
		Iterable<Education> users = this.educationRepository.findAll();

		return (List<Education>) users;
	}

	@Override
	public Education getUser(String emailId) {
		// TODO: add Resource not found exception if user is null
		return this.educationRepository.findOne(emailId);
	}

	@Override
	public Education createUser(Education user) {

		// TODO implement only for create
		return this.educationRepository.save(user);
	}

	@Override
	public Education createOrUpdateUser(Education user) {

		return this.educationRepository.save(user);
	}

	@Override
	public void deleteUser(String emailId) {

		this.educationRepository.delete(emailId);
	}

}
