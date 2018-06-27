package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

@DynamoDBTable(tableName = "UserMetaData")
public class UserMetaData {

    private String firstName;
    private String lastName;
    private String emailId;
    private String role;
    private String createdBy;
    private String lastModifiedBy;
    private UUID uuid;
    private String createdDate;
    private String lastModifiedDate;

    public UserMetaData() {
        super();
    }

    public UserMetaData(String firstName, String lastName, String emailId,
                String role, String createdBy, String lastModifiedBy,
                UUID uuid, String createdDate, String lastModifiedDate) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.role = role;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.uuid = uuid;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @DynamoDBAttribute(attributeName = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute(attributeName = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBHashKey(attributeName = "EmailId")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @DynamoDBAttribute(attributeName = "Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @DynamoDBAttribute(attributeName = "CreatedBy")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @DynamoDBAttribute(attributeName = "LastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @DynamoDBAttribute(attributeName = "Uuid")
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @DynamoDBAttribute(attributeName = "LastModifiedDate")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @DynamoDBAttribute(attributeName = "CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
