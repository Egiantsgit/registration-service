package com.egiants.rlm.entity;

import java.time.LocalDate;

public class UserImmigrationDetails {
	
	
	private String countryOfBirth;
	private String passportIssuedCountry;
	private String currentStatus;
	private LocalDate optStartDate;
	private LocalDate h1StartDate;
	private LocalDate passportExpDate;
	private String i94Number;
	private String currentStatusValidity;
	private LocalDate optEndDate;
	private LocalDate h1EndDate;
	
	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getPassportIssuedCountry() {
		return passportIssuedCountry;
	}

	public void setPassportIssuedCountry(String passportIssuedCountry) {
		this.passportIssuedCountry = passportIssuedCountry;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public  LocalDate getOptStartDate() {
		return optStartDate;
	}

	public void setOptStartDate( LocalDate optStartDate) {
		this.optStartDate = optStartDate;
	}

	public  LocalDate getH1StartDate() {
		return h1StartDate;
	}

	public void setH1StartDate( LocalDate h1StartDate) {
		this.h1StartDate = h1StartDate;
	}

	public  LocalDate getPassportExpDate() {
		return passportExpDate;
	}

	public void setPassportExpDate( LocalDate passportExpDate) {
		this.passportExpDate = passportExpDate;
	}

	public String getI94Number() {
		return i94Number;
	}

	public void setI94Number(String i94Number) {
		this.i94Number = i94Number;
	}

	public String getCurrentStatusValidity() {
		return currentStatusValidity;
	}

	public void setCurrentStatusValidity(String currentStatusValidity) {
		this.currentStatusValidity = currentStatusValidity;
	}

	public  LocalDate getOptEndDate() {
		return optEndDate;
	}

	public void setOptEndDate( LocalDate optEndDate) {
		this.optEndDate = optEndDate;
	}

	public  LocalDate getH1EndDate() {
		return h1EndDate;
	}

	public void setH1EndDate( LocalDate h1EndDate) {
		this.h1EndDate = h1EndDate;
	}
	
}