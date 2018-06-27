package com.egiants.rlm.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.egiants.rlm.entity.Gender;
import com.egiants.rlm.entity.MaritalStatus;
import com.egiants.rlm.entity.UserPersonalDetails;

import java.time.LocalDate;

public class UserPersonalDetailsConverter implements DynamoDBTypeConverter<String, UserPersonalDetails> {

    private final AddressConverter addressConverter;

    public UserPersonalDetailsConverter() {
        this.addressConverter = new AddressConverter();
    }

    @Override
    public String convert(UserPersonalDetails source) {

        if (source != null) {
            return String.format("%s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s",
                    source.getFirstName(), source.getMiddleName(), source.getLastName(),
                    source.getGender(), source.getDateOfBirth(), source.getNationality(),
                    source.getSsn(), source.getMaritalStatus(),
                    this.addressConverter.convert(source.getCurrentAddress()),
                    this.addressConverter.convert(source.getNativeAddress()),
                    source.getWorkPhoneNo(), source.getPersonalPhoneNo(), source.getEmailId());
        }
        return null;
    }

    @Override
    public UserPersonalDetails unconvert(String s) {
        // TODO: need to find a better way to convert this string to object
        UserPersonalDetails userPersonalDetails = new UserPersonalDetails();

        if (s != null && s.length() != 0) {
            String[] data = s.split("x");
            userPersonalDetails.setFirstName(data[0].trim());
            userPersonalDetails.setMiddleName(data[1].trim());
            userPersonalDetails.setLastName(data[2].trim());
            userPersonalDetails.setGender(Gender.valueOf(data[3].trim()));
            userPersonalDetails.setDateOfBirth(LocalDate.parse(data[4].trim()));
            userPersonalDetails.setNationality(data[5].trim());
            userPersonalDetails.setSsn(Integer.valueOf(data[6].trim()));
            userPersonalDetails.setMaritalStatus(MaritalStatus.valueOf(data[7].trim()));
            userPersonalDetails.setCurrentAddress(
                    this.addressConverter.unconvert(data[8].trim()));
            userPersonalDetails.setNativeAddress(
                    this.addressConverter.unconvert(data[9].trim()));
            userPersonalDetails.setWorkPhoneNo(Integer.valueOf(data[10].trim()));
            userPersonalDetails.setPersonalPhoneNo(Integer.valueOf(data[11].trim()));
            userPersonalDetails.setEmailId(data[12].trim());
        }
        return userPersonalDetails;
    }
}
