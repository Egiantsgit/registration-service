package com.egiants.rlm.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.egiants.rlm.entity.UserEducationDetails;

public class UserEducationDetailsConverter implements DynamoDBTypeConverter<String, UserEducationDetails> {

    private final AddressConverter addressConverter;

    public UserEducationDetailsConverter() {
        this.addressConverter = new AddressConverter();
    }

    @Override
    public String convert(UserEducationDetails source) {

        if (source != null) {
            return String.format("%s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s x %s",
                    source.getMastersMajor(), source.getMastersUniversity(),
                    this.addressConverter.convert(source.getMastersUniversityAddress()),
                    source.getMasterGPA(),source.getMastersStartYearAndMonth(),
                    source.getBachelorsMajor(),source.getBachelorsUniversity(),                    
                    this.addressConverter.convert(source.getBachelorsUniversityAddress()),
                    source.getBachelorsGPA(), source.getBachelorsStartYearAndMonth(),source.getInterMediateStartYearAndMonth(),
                    source.getInterMediateEndYearAndMonth(),source.getInterMediateCollage(),source.getInterMediateCollageAddress());
        }
        return null;
    }

    @Override
    public UserEducationDetails unconvert(String s) { 
        // TODO: need to find a better way to convert this string to object
    		UserEducationDetails userEducationDetails = new UserEducationDetails();

        
		if (s != null && s.length() != 0) {
            String[] data = s.split("x");
            userEducationDetails.setMastersMajor(data[0].trim());
            userEducationDetails.setMastersUniversity(data[1].trim());
            userEducationDetails.setMastersUniversityAddress(
            this.addressConverter.unconvert(data[2].trim()));
            userEducationDetails.setMasterGPA(data[3].trim());
            userEducationDetails.setMastersStartYearAndMonth(data[4].trim());
            userEducationDetails.setBachelorsMajor(data[5].trim());
            userEducationDetails.setBachelorsUniversity(data[6].trim());
            userEducationDetails.setBachelorsUniversityAddress(
                    this.addressConverter.unconvert(data[7].trim()));
            userEducationDetails.setBachelorsGPA(data[8].trim());
            userEducationDetails.setBachelorsStartYearAndMonth(data[9].trim());
            userEducationDetails.setInterMediateStartYearAndMonth(data[10].trim());
            userEducationDetails.setInterMediateEndYearAndMonth(data[11].trim());
            userEducationDetails.setInterMediateCollage(data[12].trim());
            userEducationDetails.setInterMediateCollageAddress(
            this.addressConverter.unconvert(data[13].trim()));
        }
        return userEducationDetails;
    }
    
	
	
}
