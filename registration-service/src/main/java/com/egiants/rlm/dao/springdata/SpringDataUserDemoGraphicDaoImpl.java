package com.egiants.rlm.dao.springdata;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.dao.config.DynamoDbConfig;
import com.egiants.rlm.entity.UserDemoGraphics;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SpringDataUserDemoGraphicDaoImpl implements UserDemoGraphicDao {

    @Autowired
    private UserDemoGraphicRepository userDemoGraphicRepository;

    @Autowired
    private DynamoDbConfig dynamoDbConfig;


    @Override
    public List<UserDemoGraphics> getUsersDemoGraphics() {
        // TODO Auto-generated method stub
        Iterable<UserDemoGraphics> usersDemoGraphics = this.userDemoGraphicRepository.findAll();

        return Lists.newArrayList(usersDemoGraphics);
    }

    @Override
    public UserDemoGraphics getUserDemoGraphicInfo(UUID uuid) {
        // TODO: add Resource not found exception if user is null
        return this.userDemoGraphicRepository.findOne(uuid);
    }

    @Override
    public UserDemoGraphics createUserDemoGraphicInfo(UserDemoGraphics userDemoGraphics) {

        // TODO implement only for create
        return this.userDemoGraphicRepository.save(userDemoGraphics);
    }

    @Override
    public UserDemoGraphics updateUserDemoGraphicInfo(UserDemoGraphics userDemoGraphics) {

        return this.userDemoGraphicRepository.save(userDemoGraphics);
    }

    @Override
    public void deleteUserDemoGraphicInfo(UUID uuid) {

        this.userDemoGraphicRepository.delete(uuid);
    }

}
