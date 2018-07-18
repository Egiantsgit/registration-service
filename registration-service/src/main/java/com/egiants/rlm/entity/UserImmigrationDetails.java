package com.egiants.rlm.entity;

import javax.validation.constraints.NotNull;

public class UserImmigrationDetails {

    @NotNull(message = "countryOfBirth Can't be Null")
    private String countryOfBirth;
    @NotNull(message = "passportExpiryDate Can't be Null")
    private String passportExpiryDate;
    @NotNull(message = "passportIssuedCountry Can't be Null")
    private String passportIssuedCountry;
    @NotNull(message = "i94Number Can't be Null")
    private Integer i94Number;
    //TODO: may be this should be enum
    @NotNull(message = "currentStatus Can't be Null")
    private String currentStatus;
    @NotNull(message = "currentStatusValidity Can't be Null")
    private String currentStatusValidity;
    //TODO: ideally this start and end date should auto populate based on status
    //TODO: not sure this date fields can be strings
    private String optStartDate;
    private String optEndDate;
    private String h1bStartDate;
    private String h1bEndDate;

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(String passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }

    public String getPassportIssuedCountry() {
        return passportIssuedCountry;
    }

    public void setPassportIssuedCountry(String passportIssuedCountry) {
        this.passportIssuedCountry = passportIssuedCountry;
    }

    public Integer getI94Number() {
        return i94Number;
    }

    public void setI94Number(Integer i94Number) {
        this.i94Number = i94Number;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatusValidity() {
        return currentStatusValidity;
    }

    public void setCurrentStatusValidity(String currentStatusValidity) {
        this.currentStatusValidity = currentStatusValidity;
    }

    public String getOptStartDate() {
        return optStartDate;
    }

    public void setOptStartDate(String optStartDate) {
        this.optStartDate = optStartDate;
    }

    public String getOptEndDate() {
        return optEndDate;
    }

    public void setOptEndDate(String optEndDate) {
        this.optEndDate = optEndDate;
    }

    public String getH1bStartDate() {
        return h1bStartDate;
    }

    public void setH1bStartDate(String h1bStartDate) {
        this.h1bStartDate = h1bStartDate;
    }

    public String getH1bEndDate() {
        return h1bEndDate;
    }

    public void setH1bEndDate(String h1bEndDate) {
        this.h1bEndDate = h1bEndDate;
    }
}
