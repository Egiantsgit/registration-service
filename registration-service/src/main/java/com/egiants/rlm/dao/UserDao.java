package com.egiants.rlm.dao;

import com.egiants.rlm.entity.User;

import java.util.List;


public interface UserDao {

    List<User> getUsers();

    User getUser(String emailId);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(String emailId);
}
