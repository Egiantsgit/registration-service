package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserDemoGraphic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDemoGraphicServiceImpl implements UserDemoGraphicService {

    @Autowired
    private UserDemoGraphicDao UserDemoGraphicDao;
    @Autowired
    private UserService userService;

    @Override
    public List<UserDemoGraphic> getUsers() {
        return this.UserDemoGraphicDao.getUsers();
    }

    @Override
    public UserDemoGraphic getUser(String emailId) {
        return this.UserDemoGraphicDao.getUser(emailId);
    }

    @Override
    public UserDemoGraphic createUser(UserDemoGraphic userDemoGraphic) {
        User user = this.userService.getUser(userDemoGraphic.getEmailId());
        if (user == null) {
            //throw new Exception(); need to throw some custom exception
        }
        //TODO: update userDemoGraphic model object with UUID
        return this.UserDemoGraphicDao.createUser(user);
    }

    @Override
    public UserDemoGraphic createOrUpdateUser(UserDemoGraphic user) {
        return this.UserDemoGraphicDao.createOrUpdateUser(user);
    }

    @Override
    public void deleteUser(String emailId) {
        this.UserDemoGraphicDao.deleteUser(emailId);
    }

}
