package com.egiants.rlm.dao;

import com.egiants.rlm.entity.UserMetaData;

import java.util.List;


public interface UserMetaDataDao {

    List<UserMetaData> getUsersMetaData();

    UserMetaData getUserMetaData(String emailId);

    UserMetaData createUserMetaData(UserMetaData userMetaData);

    UserMetaData updateUserMetaData(UserMetaData userMetaData);

    void deleteUserMetaData(String emailId);
}
