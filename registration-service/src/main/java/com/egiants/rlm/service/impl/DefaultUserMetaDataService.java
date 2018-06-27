package com.egiants.rlm.service.impl;

import com.egiants.rlm.dao.UserMetaDataDao;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.UserMetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserMetaDataService implements UserMetaDataService {

    @Autowired
    private UserMetaDataDao userMetaDataDao;

    @Override
    public List<UserMetaData> getUsersMetaData() {
        return this.userMetaDataDao.getUsersMetaData();
    }

    @Override
    public UserMetaData getUserMetaData(String emailId) {
        //TODO: throw custom error if there is no record
        return this.userMetaDataDao.getUserMetaData(emailId);
    }

    @Override
    public UserMetaData createUserMetaData(UserMetaData userMetaData) {
        return this.userMetaDataDao.createUserMetaData(userMetaData);
    }

    @Override
    public UserMetaData updateUserMetaData(UserMetaData userMetaData) {
        return this.userMetaDataDao.updateUserMetaData(userMetaData);
    }

    @Override
    public void deleteUserMetaData(String emailId) {
        //TODO: may need to throw error based on
        this.userMetaDataDao.deleteUserMetaData(emailId);
    }
}
