package com.egiants.rlm.dao;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egiants.rlm.entity.UserImmigrationDetails;

@EnableScan
@Repository
public interface UserImmigrationDetailsRepository extends CrudRepository<UserImmigrationDetails, String> {
		
}
