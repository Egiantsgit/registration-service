package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserImmigrationDetailsDao;
import com.egiants.rlm.entity.UserImmigrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserImmigrationDetailsServiceImpl implements UserImmigrationDetailsService {

    @Autowired
    private UserImmigrationDetailsDao userImmigrationDetailsDao;


    @Override
    public List<UserImmigrationDetails> getAllUserImmigrationDetails() {
        return userImmigrationDetailsDao.getAllUserImmigrationDetails();
    }

    @Override
    public UserImmigrationDetails getUserImmigrationDetails(String uuid) {
        return userImmigrationDetailsDao.getUserImmigrationDetails(uuid);
    }

    @Override
    public UserImmigrationDetails createUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
        UUID id = UUID.randomUUID();
        userImmigrationDetails.setUuid(id.toString());
        return userImmigrationDetailsDao.createUserImmigrationDetails(userImmigrationDetails);
    }

    @Override
    public UserImmigrationDetails createOrUpdateUserImmigrationDetails(UserImmigrationDetails userImmigrationDetails) {
        return this.userImmigrationDetailsDao.createOrUpdateUserImmigrationDetails(userImmigrationDetails);
    }

    @Override
    public void deleteUserImmigrationDetails(String uuid) {
        this.userImmigrationDetailsDao.deleteUserImmigrationDetails(uuid);
    }

}
