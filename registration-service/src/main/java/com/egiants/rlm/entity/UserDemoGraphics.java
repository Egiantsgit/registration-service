package com.egiants.rlm.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.egiants.rlm.converter.AddressItemConverter;

import java.time.LocalDate;
import java.util.UUID;

@DynamoDBTable(tableName = "UserDemoGraphics")
public class UserDemoGraphics {

    // TODO: need to add external and entity model objects to isolate this
    // attributes
    private UUID uuid;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String nationality;
    private Integer ssn;
    private MaritalStatus maritalStatus;
    private Address currentAddress;
    private Address nativeAddress;
    private Integer workPhoneNo;
    private Integer personalPhoneNo;
    private String emailId;
    // drivers license or state Id
    // Bank statement

    @DynamoDBHashKey(attributeName = "uuid")
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

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

    @DynamoDBAttribute(attributeName = "dateOfBirth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @DynamoDBAttribute(attributeName = "nationality")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @DynamoDBAttribute(attributeName = "ssn")
    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "maritalStatus")
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @DynamoDBTypeConverted(converter = AddressItemConverter.class)
    @DynamoDBAttribute(attributeName = "currentAddress")
    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    @DynamoDBTypeConverted(converter = AddressItemConverter.class)
    @DynamoDBAttribute(attributeName = "nativeAddress")
    public Address getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(Address nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    @DynamoDBAttribute(attributeName = "workPhoneNo")
    public Integer getWorkPhoneNo() {
        return workPhoneNo;
    }

    public void setWorkPhoneNo(Integer workPhoneNo) {
        this.workPhoneNo = workPhoneNo;
    }

    @DynamoDBAttribute(attributeName = "personalPhoneNo")
    public Integer getPersonalPhoneNo() {
        return personalPhoneNo;
    }

    public void setPersonalPhoneNo(Integer personalPhoneNo) {
        this.personalPhoneNo = personalPhoneNo;
    }

    @DynamoDBAttribute(attributeName = "emailId")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
