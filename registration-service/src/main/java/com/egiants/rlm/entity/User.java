package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.egiants.rlm.converter.UserEducationDetailsConverter;
import com.egiants.rlm.converter.UserImmigrationDetailsConverter;
import com.egiants.rlm.converter.UserPersonalDetailsConverter;
import com.egiants.rlm.converter.UserWorkExperienceConverter;

import java.util.UUID;

@DynamoDBTable(tableName = "User")
public class User {

	private UUID uuid; 
	private UserPersonalDetails userPersonalDetails;
	private UserEducationDetails userEducationDetails;
	private UserImmigrationDetails userImmigrationDetails;
	private UserWorkExperience userworkExperience;
	private String createdBy;
	private String lastModifiedBy;

	@DynamoDBHashKey(attributeName = "uuid")
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	@DynamoDBTypeConverted(converter = UserPersonalDetailsConverter.class)
	@DynamoDBAttribute(attributeName = "UserPersonalDetails")
	
	public UserPersonalDetails getUserPersonalDetails() {
		return userPersonalDetails;
	}

	public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
		this.userPersonalDetails = userPersonalDetails;
	}
	@DynamoDBTypeConverted(converter = UserEducationDetailsConverter.class)
	@DynamoDBAttribute(attributeName = "UserEducationDetails")
	
	public UserEducationDetails getUserEducationDetails() {
		return userEducationDetails;
	}

	public void setUserEducationDetails(UserEducationDetails userEducationDetails) {
		this.userEducationDetails = userEducationDetails;
	}
	
	@DynamoDBTypeConverted(converter = UserImmigrationDetailsConverter.class)
	@DynamoDBAttribute(attributeName = "UserImmigrationDetails")
	public UserImmigrationDetails getUserImmigrationDetails() {
		return userImmigrationDetails;
	}

	public void setUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
		this.userImmigrationDetails = userImmigrationDetails;
	}

	@DynamoDBTypeConverted(converter = UserWorkExperienceConverter.class)
	@DynamoDBAttribute(attributeName = "UserworkExperience")
	public UserWorkExperience getUserworkExperience() {
		return userworkExperience;
	}

	public void setUserworkExperience(UserWorkExperience userworkExperience) {
		this.userworkExperience = userworkExperience;
	}
	@DynamoDBAttribute(attributeName = "createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@DynamoDBAttribute(attributeName = "lastModifiedBy")
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	

}
