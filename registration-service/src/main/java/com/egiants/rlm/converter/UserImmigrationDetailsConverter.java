package com.egiants.rlm.converter;
	
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import com.egiants.rlm.entity.UserImmigrationDetails;

import java.time.LocalDate;

public class UserImmigrationDetailsConverter implements DynamoDBTypeConverter<String, UserImmigrationDetails> {

    @Override
    public String convert(UserImmigrationDetails source) {

        if (source != null) {
            return String.format(" %s x %s x %s x %s x %s x %s x %s x %s x %s",
                    source.getCountryOfBirth(), source.getPassportIssuedCountry(),
                    source.getCurrentStatus(), source.getOptStartDate(), source.getH1StartDate(),
                    source.getPassportExpDate(), source.getI94Number(),
                    source.getCurrentStatusValidity(), source.getOptEndDate(), source.getH1EndDate());
        }
        return null;
    }

    @Override
    public UserImmigrationDetails unconvert(String s) {
        // TODO: need to find a better way to convert this string to object
        UserImmigrationDetails userImmigrationDetails = new UserImmigrationDetails();

        if (s != null && s.length() != 0) {
            String[] data = s.split("x");
            userImmigrationDetails.setCountryOfBirth(data[0].trim());
            userImmigrationDetails.setPassportIssuedCountry(data[1].trim());
            userImmigrationDetails.setCurrentStatus(data[2].trim());
            userImmigrationDetails.setOptEndDate(LocalDate.parse(data[3].trim()));
            userImmigrationDetails.setH1StartDate(LocalDate.parse(data[4].trim()));
            userImmigrationDetails.setPassportExpDate(LocalDate.parse(data[5].trim()));
            userImmigrationDetails.setI94Number(data[6].trim());
            userImmigrationDetails.setCurrentStatusValidity(data[7].trim());
            userImmigrationDetails.setOptEndDate(LocalDate.parse(data[8].trim()));
            userImmigrationDetails.setH1EndDate(LocalDate.parse(data[9].trim()));
        }
        return userImmigrationDetails;
    }
 }

