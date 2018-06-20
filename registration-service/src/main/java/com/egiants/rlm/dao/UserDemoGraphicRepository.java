package com.egiants.rlm.dao;

import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.rlm.entity.UserDemoGraphic;

@EnableScan
public interface UserDemoGraphicRepository extends DynamoDBCrudRepository<UserDemoGraphic, String> {

	void delete(UUID uuid);

	UserDemoGraphic findOne(UUID uuid);

}
