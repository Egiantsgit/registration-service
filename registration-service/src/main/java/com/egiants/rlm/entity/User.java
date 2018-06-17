package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBTable(tableName = "User")
public class User {

	private String firstName;
	private String lastName;
	private String emailId;
	private String role;
	private String createdBy;
	private String lastModifiedBy;
	private UUID uid;
	private String createdDateTime;
	private String lastModifiedDateTime;

	public User() {
		super();
	}

	public User(String firstName, String lastName, String emailId, String role, String createdBy, String lastModifiedBy,
			UUID uid, String createdDateTime, String lastModifiedDateTime) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.role = role;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.uid = uid;
		this.createdDateTime = createdDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBHashKey(attributeName = "emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@DynamoDBAttribute(attributeName = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	@DynamoDBAttribute(attributeName = "uid")
	public UUID getUid() {
		return uid;
	}

	public void setUid(UUID uid) {
		this.uid = uid;
	}

	@DynamoDBAttribute(attributeName = "lastModifiedDateTime")
	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@DynamoDBAttribute(attributeName = "createdDateTime")
	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

}
