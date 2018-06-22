package com.egiants.rlm.entity;

import java.time.LocalDate;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "UserImmigrationDetails")
public class UserImmigrationDetails {
	
	private String uuid;
	private String countryOfBirth;
	private String passportIssuedCountry;
	private String currentStatus;
	private Date optStartDate;
	private Date h1StartDate;
	private Date passportExpDate;
	private String i94Number;
	private String currentStatusValidity;
	private Date optEndDate;
	private Date h1EndDate;
	
	public UserImmigrationDetails() {
		
	}
	
	@DynamoDBHashKey
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

    @DynamoDBAttribute
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

    @DynamoDBAttribute
	public String getPassportIssuedCountry() {
		return passportIssuedCountry;
	}

	public void setPassportIssuedCountry(String passportIssuedCountry) {
		this.passportIssuedCountry = passportIssuedCountry;
	}

    @DynamoDBAttribute
	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

    @DynamoDBAttribute
	public  Date getOptStartDate() {
		return optStartDate;
	}

	public void setOptStartDate( Date optStartDate) {
		this.optStartDate = optStartDate;
	}

    @DynamoDBAttribute
	public  Date getH1StartDate() {
		return h1StartDate;
	}

	public void setH1StartDate( Date h1StartDate) {
		this.h1StartDate = h1StartDate;
	}

    @DynamoDBAttribute
	public  Date getPassportExpDate() {
		return passportExpDate;
	}

	public void setPassportExpDate( Date passportExpDate) {
		this.passportExpDate = passportExpDate;
	}

    @DynamoDBAttribute
	public String getI94Number() {
		return i94Number;
	}

	public void setI94Number(String i94Number) {
		this.i94Number = i94Number;
	}

    @DynamoDBAttribute
	public String getCurrentStatusValidity() {
		return currentStatusValidity;
	}

	public void setCurrentStatusValidity(String currentStatusValidity) {
		this.currentStatusValidity = currentStatusValidity;
	}

    @DynamoDBAttribute
	public  Date getOptEndDate() {
		return optEndDate;
	}

	public void setOptEndDate( Date optEndDate) {
		this.optEndDate = optEndDate;
	}

    @DynamoDBAttribute
	public  Date getH1EndDate() {
		return h1EndDate;
	}

	public void setH1EndDate( Date h1EndDate) {
		this.h1EndDate = h1EndDate;
	}
	
}