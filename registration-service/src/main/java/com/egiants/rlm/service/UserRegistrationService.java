package com.egiants.rlm.service;

import com.egiants.rlm.entity.User;

import java.util.List;


public interface UserRegistrationService {

    List<User> getUsers();

    User getUser(String emailId);

    User createUser(String emailId, User user);

    User updateUser(String emailId, User user);

    void deleteUser(String emailId);

}
