package com.egiants.rlm.dao;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.rlm.entity.UserDemoGraphic;

@EnableScan
public interface UserDemoGraphicRepository extends DynamoDBCrudRepository<UserDemoGraphic, String> {

}
