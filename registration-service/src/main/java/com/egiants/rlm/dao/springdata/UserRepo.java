package com.egiants.rlm.dao.springdata;


import com.egiants.rlm.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import java.util.UUID;

@EnableScan
public interface UserRepo extends DynamoDBCrudRepository<User, UUID> {

}
