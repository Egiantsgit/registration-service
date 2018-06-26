package com.egiants.rlm.dao;

import com.egiants.rlm.entity.User;

import java.util.List;
import java.util.UUID;


public interface UserRegistrationDao {

    List<User> getUsers();

    User getUser(UUID uuid);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(UUID uuid);
}
