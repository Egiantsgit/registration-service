package com.egiants.rlm.dao.springdata;


import com.egiants.rlm.entity.UserMetaData;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface UserMetaDataRepo extends DynamoDBCrudRepository<UserMetaData, String> {

}
