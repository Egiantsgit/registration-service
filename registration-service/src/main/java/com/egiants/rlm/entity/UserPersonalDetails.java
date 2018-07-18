package com.egiants.rlm.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserPersonalDetails {

    // TODO: need to add external and entity model objects to isolate this

    //TODO: need to add size constrain
    @NotNull(message = "firstName Can't be Null")
    private String firstName;
    @NotNull(message = "middleName Can't be Null")
    private String middleName;
    @NotNull(message = "lastName Can't be Null")
    private String lastName;
    @NotNull(message = "gender Should be Enum type MALE or FEMALE")
    private Gender gender;
    @NotNull(message = "dateOfBirth Can't be Null")
    private String dateOfBirth;
    @NotNull(message = "nationality Can't be Null")
    private String nationality;
    @NotNull(message = "ssn Can't be Null")
    private Integer ssn;
    @NotNull(message = "maritalStatus Should be Enum type SINGLE or MARRIED")
    private MaritalStatus maritalStatus;
    @Valid
    private Address primaryAddress;
    @Valid
    private Address secondaryAddress;
    private Integer workPhoneNo;
    @NotNull(message = "personalPhoneNo Can't be Null")
    private Integer personalPhoneNo;
    @NotNull(message = "emailId Can't be Null")
    private String emailId;
    // drivers license or state Id
    // Bank statement

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() { return this.dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Address getPrimaryAddress() { return this.primaryAddress; }

    public void setPrimaryAddress(Address primaryAddress) { this.primaryAddress = primaryAddress; }

    public Address getSecondaryAddress() { return this.secondaryAddress; }

    public void setSecondaryAddress(Address secondaryAddress) { this.secondaryAddress = secondaryAddress; }

    public Integer getWorkPhoneNo() {
        return workPhoneNo;
    }

    public void setWorkPhoneNo(Integer workPhoneNo) {
        this.workPhoneNo = workPhoneNo;
    }

    public Integer getPersonalPhoneNo() {
        return personalPhoneNo;
    }

    public void setPersonalPhoneNo(Integer personalPhoneNo) {
        this.personalPhoneNo = personalPhoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
