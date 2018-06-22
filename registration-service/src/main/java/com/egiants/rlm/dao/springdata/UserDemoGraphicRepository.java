package com.egiants.rlm.dao.springdata;

import com.egiants.rlm.entity.UserDemoGraphics;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.UUID;

@Repository
public interface UserDemoGraphicRepository extends DynamoDBCrudRepository<UserDemoGraphics, UUID> {

}
