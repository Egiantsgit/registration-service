package com.egiants.rlm.service.impl;

import com.egiants.rlm.dao.UserRegistrationDao;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.UserMetaDataService;
import com.egiants.rlm.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class DefaultUserRegistrationService implements UserRegistrationService {

    @Autowired
    private UserRegistrationDao userRegistrationDao;

    @Autowired
    private UserMetaDataService userMetaDataService;

    @Override
    public List<User> getUsers() {
        return this.userRegistrationDao.getUsers();
    }

    @Override
    public User getUser(String emailId) {

        UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(emailId);
        if(userMetaData == null) {
            //TODO: throw Exception saying there admin need to register before registration process
        }
        return this.userRegistrationDao.getUser(userMetaData.getUuid());
    }

    @Override
    public User createUser(User user) {
        /*UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(user.get);
        if(userMetaData == null) {
            //TODO: throw Exception saying there admin need to register before registration process
        }*/
        return this.userRegistrationDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userRegistrationDao.updateUser(user);
    }

    @Override
    public void deleteUser(String emailId) {
        UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(emailId);
        try {
            this.userRegistrationDao.deleteUser(userMetaData.getUuid());
        } catch (Exception e) {
            //TODO: no need worry for exception saying no record
        }
    }
}
