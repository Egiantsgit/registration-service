package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDao;
import com.egiants.rlm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return this.userDao.getUsers();
    }

    @Override
    public User getUser(String emailId) {
        //TODO add exception
        return this.userDao.getUser(emailId);
    }

    @Override
    public User createUser(User user) {

        UUID id = UUID.randomUUID();
        user.setUid(id);
        //TODO: duplicate key exception
        return this.userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String emailId) {
        this.userDao.deleteUser(emailId);
    }

}
