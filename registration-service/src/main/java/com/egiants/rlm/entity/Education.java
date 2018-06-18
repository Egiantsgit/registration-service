package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBTable(tableName = "education")
public class Education {
	private String emailId;
	private String MastersUniversity;
	private String MastersAddress;
	private String MastersGPA;
	private String MastersMajor;
	private String BachelorsUniversity;
	private String BachelorsAddress;
	private String BachelorsGPA;
	private String BachelorsMajor;

	// private ZonedDateTime createdDate;
	// private ZonedDateTime lastModifiedDate;
	@DynamoDBHashKey(attributeName = "emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@DynamoDBAttribute(attributeName = "MastersUniversity")
	public String getMastersUniversity() {
		return MastersUniversity;
	}

	public void setMastersUniversity(String mastersUniversity) {
		MastersUniversity = mastersUniversity;
	}

	@DynamoDBAttribute(attributeName = "MastersAddres")
	public String getMastersAddress() {
		return MastersAddress;
	}

	public void setMastersAddress(String mastersAddress) {
		MastersAddress = mastersAddress;
	}

	@DynamoDBAttribute(attributeName = "MastersGPA")
	public String getMastersGPA() {
		return MastersGPA;
	}

	public void setMastersGPA(String mastersGPA) {
		MastersGPA = mastersGPA;
	}

	@DynamoDBAttribute(attributeName = "MastersMajor")
	public String getMastersMajor() {
		return MastersMajor;
	}

	public void setMastersMajor(String mastersMajor) {
		MastersMajor = mastersMajor;
	}

	@DynamoDBAttribute(attributeName = "BachelorsUniversity")
	public String getBachelorsUniversity() {
		return BachelorsUniversity;
	}

	public void setBachelorsUniversity(String bachelorsUniversity) {
		BachelorsUniversity = bachelorsUniversity;
	}

	@DynamoDBAttribute(attributeName = "BachelorsAddress")
	public String getBachelorsAddress() {
		return BachelorsAddress;
	}

	public void setBachelorsAddress(String bachelorsAddress) {
		BachelorsAddress = bachelorsAddress;
	}

	@DynamoDBAttribute(attributeName = "BachelorsGPA")
	public String getBachelorsGPA() {
		return BachelorsGPA;
	}

	public void setBachelorsGPA(String bachelorsGPA) {
		BachelorsGPA = bachelorsGPA;
	}

	@DynamoDBAttribute(attributeName = "BachelorsMajor")
	public String getBachelorsMajor() {
		return BachelorsMajor;
	}

	public void setBachelorsMajor(String bachelorsMajor) {
		BachelorsMajor = bachelorsMajor;
	}

}
