package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserPersonalDetails {

    // TODO: need to add external and entity model objects to isolate this
    // attributes
    @NotNull(message = "FirstName Can't be Null")
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

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

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getNativeAddress() {
        return nativeAddress;
    }

    public void setNativeAddress(Address nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

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
