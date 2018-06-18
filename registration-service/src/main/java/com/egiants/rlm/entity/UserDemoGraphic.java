package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

@DynamoDBTable(tableName = "userDemoGraphic")
public class UserDemoGraphic {

	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private String DateOfBirth;
	private String Nationality;
	private MaritalStatus MaritalStatus;
	private long workPhoneNo;
	private long personalPhoneNo;
	private String emailId;
	private Address address;
	// Bank statement

	@DynamoDBAttribute(attributeName = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName = "middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@DynamoDBAttribute(attributeName = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBTypeConvertedEnum
	@DynamoDBAttribute(attributeName = "gender")
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@DynamoDBAttribute(attributeName = "DateOfBirth")
	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	@DynamoDBAttribute(attributeName = "Nationality")
	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	@DynamoDBTypeConvertedEnum
	@DynamoDBAttribute(attributeName = "MaritalStatus")
	public MaritalStatus getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	@DynamoDBAttribute(attributeName = "WorkPhoneNo")
	public long getWorkPhoneNo() {
		return workPhoneNo;
	}

	public void setWorkPhoneNo(long workPhoneNo) {
		this.workPhoneNo = workPhoneNo;
	}

	@DynamoDBAttribute(attributeName = "personalPhoneNo")
	public long getPersonalPhoneNo() {
		return personalPhoneNo;
	}

	public void setPersonalPhoneNo(long personalPhoneNo) {
		this.personalPhoneNo = personalPhoneNo;
	}

	@DynamoDBHashKey(attributeName = "emailId")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@DynamoDBTypeConverted(converter = AddressConverter.class)
	@DynamoDBAttribute(attributeName = "address")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Converts the complex type DimensionType to a string and vice-versa.
	static public class AddressConverter implements DynamoDBTypeConverter<String, Address> {

		@Override
		public String convert(Address object) {
			Address addressDetails = (Address) object;
			String Address = null;
			try {
				if (addressDetails != null) {
					Address = String.format("%s x %s x %s %s x %s ", addressDetails.getLine1(),
							addressDetails.getLine2(), addressDetails.getCity(), addressDetails.getState(),
							addressDetails.getPostalcode());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Address;
		}

		@Override
		public Address unconvert(String s) {

			Address addressDetails = new Address();
			try {
				if (s != null && s.length() != 0) {
					String[] data = s.split("x");
					addressDetails.setLine1(data[0].trim());
					addressDetails.setLine2(data[1].trim());
					addressDetails.setCity(data[2].trim());
					addressDetails.setState(data[3].trim());
					addressDetails.setPostalcode(data[4].trim());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return addressDetails;
		}
	}

}
