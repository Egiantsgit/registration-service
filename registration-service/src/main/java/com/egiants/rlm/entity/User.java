package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

import javax.validation.Valid;
import java.util.UUID;

@DynamoDBTable(tableName = "User")
public class User {

    private UUID uuid;
    @Valid
    private UserPersonalDetails userPersonalDetails;
    @Valid
    private UserEducationDetails userEducationDetails;
    @Valid
    private UserImmigrationDetails userImmigrationDetails;
    @Valid
    private UserWorkExperience userWorkExperience;
    private String createdBy;
    private String lastModifiedBy;

    @DynamoDBHashKey(attributeName = "Uuid")
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "UserPersonalDetails")
    public UserPersonalDetails getUserPersonalDetails() {
        return this.userPersonalDetails;
    }

    public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
        this.userPersonalDetails = userPersonalDetails;
    }

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "UserEducationDetails")
    public UserEducationDetails getUserEducationDetails() { return this.userEducationDetails; }

    public void setUserEducationDetails(UserEducationDetails userEducationDetails) {
        this.userEducationDetails = userEducationDetails;
    }

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "UserImmigrationDetails")
    public UserImmigrationDetails getUserImmigrationDetails() {
        return userImmigrationDetails;
    }

    public void setUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
        this.userImmigrationDetails = userImmigrationDetails;
    }

    @DynamoDBTypeConvertedJson
    @DynamoDBAttribute(attributeName = "UserWorkExperience")
    public UserWorkExperience getUserWorkExperience() {
        return userWorkExperience;
    }

    public void setUserWorkExperience(UserWorkExperience userWorkExperience) {
        this.userWorkExperience = userWorkExperience;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
