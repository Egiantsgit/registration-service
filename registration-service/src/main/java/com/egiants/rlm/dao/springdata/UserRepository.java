package com.egiants.rlm.dao.springdata;



import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.rlm.entity.User;

@EnableScan
public interface UserRepository extends DynamoDBCrudRepository<User, String> {
	
}
