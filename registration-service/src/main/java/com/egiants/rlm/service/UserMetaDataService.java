package com.egiants.rlm.service;

import com.egiants.rlm.entity.UserMetaData;

import java.util.List;


public interface UserMetaDataService {

    List<UserMetaData> getUsersMetaData();

    UserMetaData getUserMetaData(String emailId);

    UserMetaData createUserMetaData(UserMetaData userMetaData);

    UserMetaData updateUserMetaData(UserMetaData userMetaData);

    void deleteUserMetaData(String emailId);

}
