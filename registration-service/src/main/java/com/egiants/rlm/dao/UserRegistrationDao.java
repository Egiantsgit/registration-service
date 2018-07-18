package com.egiants.rlm.dao;

import com.egiants.rlm.entity.User;

import java.util.List;
import java.util.UUID;


public interface UserRegistrationDao {

    List<User> getUsers();

//    User getUser(UUID uuid);

    User getUser(String EMAIL_ID);


    User createUser(String EMAIL_ID,User user);

    User updateUser(String EMAIL_ID,User user);

    void deleteUser(String EMAIL_ID);
}
