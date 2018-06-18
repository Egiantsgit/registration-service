package com.egiants.rlm.dao;

import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import com.egiants.rlm.entity.Education;

@EnableScan
public interface EducationRepository extends DynamoDBCrudRepository<Education, String> {

}
