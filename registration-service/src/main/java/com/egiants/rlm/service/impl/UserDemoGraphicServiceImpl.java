/*
package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserDemoGraphics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDemoGraphicServiceImpl implements UserDemoGraphicService {

    @Autowired
    private UserDemoGraphicDao userDemoGraphicDao;
    @Autowired
    private UserService userService;

    @Override
    public List<UserDemoGraphics> getUsersDemoGraphics() {
        return this.userDemoGraphicDao.getUsersDemoGraphics();
    }

    @Override
    public UserDemoGraphics getUserDemoGraphicInfo(String emailId) {
        User user = this.userService.getUser(emailId);
        // if(user==null) {
        // // throw new Exception(); need to throw some custom exception
        // }
        return this.userDemoGraphicDao.getUserDemoGraphicInfo(user.getUuid());
    }

    @Override
    public UserDemoGraphics createUserDemoGraphicInfo(UserDemoGraphics userDemoGraphics) {
        User user = this.userService.getUser(userDemoGraphics.getEmailId());
        if (user == null) {
            // throw new Exception(); need to throw some custom exception
        }
        // TODO: update userDemoGraphic model object with UUID
        userDemoGraphics.setUuid(user.getUuid());
        return this.userDemoGraphicDao.createUserDemoGraphicInfo(userDemoGraphics);
    }

    @Override
    public UserDemoGraphics updateUserDemoGraphicInfo(UserDemoGraphics userDemoGraphics) {
        User user = this.userService.getUser(userDemoGraphics.getEmailId());

        userDemoGraphics.setUuid(user.getUuid());
        return this.userDemoGraphicDao.updateUserDemoGraphicInfo(userDemoGraphics);
    }

    @Override
    public void deleteUserDemoGraphicInfo(String emailId) {
        User user = this.userService.getUser(emailId);
        // if(user==null) {
        // // throw new Exception(); need to throw some custom exception
        // }
        this.userDemoGraphicDao.deleteUserDemoGraphicInfo(user.getUuid());
    }

}
*/
