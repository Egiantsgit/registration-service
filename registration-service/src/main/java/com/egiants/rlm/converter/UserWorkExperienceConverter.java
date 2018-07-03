package com.egiants.rlm.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import com.egiants.rlm.entity.UserWorkExperience;

public class UserWorkExperienceConverter implements DynamoDBTypeConverter<String, UserWorkExperience> {


    @Override
    public String convert(UserWorkExperience source) {

        if (source != null) {
            return String.format("%s x %s x %s x %s x %s x %s x %s x %s",
                    source.getTotalWorkExperience(), source.getCompanyName(), source.getComapanyLocation(),
                    source.getPreviousExperience(), source.getTotalYearsOfWorkExperience(), source.getFieldOfPreviousWorkExperience(),
                    source.getStartYearAndStartMonth(), source.getUploadWorkExperienceLetterOrOfferLetter());
                   
        }
        return null;
    }

    @Override
    public UserWorkExperience unconvert(String s) {
        // TODO: need to find a better way to convert this string to object
        UserWorkExperience userWorkExperience = new UserWorkExperience();

        if (s != null && s.length() != 0) {
            String[] data = s.split("x");
            userWorkExperience.setTotalWorkExperience(data[0].trim());
            userWorkExperience.setCompanyName(data[1].trim());
            userWorkExperience.setComapanyLocation(data[2].trim());
            userWorkExperience.setPreviousExperience(data[3].trim());
            userWorkExperience.setTotalYearsOfWorkExperience(data[4].trim());
            userWorkExperience.setFieldOfPreviousWorkExperience(data[5].trim());
            userWorkExperience.setStartYearAndStartMonth(data[6].trim());
            userWorkExperience.setUploadWorkExperienceLetterOrOfferLetter(data[7].trim());
      
        }
		return userWorkExperience;
    
}


}
