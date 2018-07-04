package com.egiants.rlm.service.impl;

import com.egiants.rlm.Exceptions.ResourceNotFoundException;
import com.egiants.rlm.Exceptions.UserMetaDataException;
import com.egiants.rlm.dao.UserRegistrationDao;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.UserMetaDataService;
import com.egiants.rlm.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        if (userMetaData == null) {
            throw new UserMetaDataException(emailId);
        }
        User user = this.userRegistrationDao.getUser(userMetaData.getUuid());
        if(user ==null) {
            throw new ResourceNotFoundException(emailId);
        }
        return user;
    }

    @Override
    public User createUser(String emailId, User user) {
        UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(emailId);
        if (userMetaData == null) {
            throw new UserMetaDataException(emailId);
        }
        user.setUuid(userMetaData.getUuid());

        return this.userRegistrationDao.createUser(user);
    }

    @Override
    public User updateUser(String emailId, User user) {
        UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(emailId);
        if (userMetaData == null) {
            throw new UserMetaDataException(emailId);
        }
        user.setUuid(userMetaData.getUuid());

        return this.userRegistrationDao.updateUser(user);
    }

    @Override
    public void deleteUser(String emailId) {
        UserMetaData userMetaData = this.userMetaDataService.getUserMetaData(emailId);
        try {
            this.userRegistrationDao.deleteUser(userMetaData.getUuid());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(emailId);
        }
    }
}
