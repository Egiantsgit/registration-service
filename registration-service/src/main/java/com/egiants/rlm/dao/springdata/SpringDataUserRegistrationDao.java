package com.egiants.rlm.dao.springdata;

import com.egiants.rlm.dao.UserRegistrationDao;
import com.egiants.rlm.dao.config.DynamoDbConfig;
import com.egiants.rlm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class SpringDataUserRegistrationDao implements UserRegistrationDao {

    @Autowired
    DynamoDbConfig dynamoDbConfig;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {

        Iterable<User> users = this.userRepo.findAll();

        return (List<User>) users;
    }

    @Override
    public User getUser(UUID uuid) {
        // TODO: add Resource not found exception if user is null
        return this.userRepo.findOne(uuid);

    }

    @Override
    public User createUser(User user) {

        ZonedDateTime newDate = ZonedDateTime.now(ZoneId.systemDefault());

        /*user.setLastModifiedDate(newDate.toString());
        user.setCreatedDate(newDate.toString());*/

        return this.userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {

        return this.userRepo.save(user);//customUpdate(user);

    }

    @Override
    public void deleteUser(UUID uuid) {

        this.userRepo.delete(uuid);
    }

    /*public User customUpdate(User user) {

        User old = this.userRepository.findOne(user.getEmailId());

		*//* not changing EmailId, CreatedBy, UUID, CreatedDate *//*

        old.setFirstName(user.getFirstName());
        old.setLastName(user.getLastName());
        old.setRole(user.getRole());
        old.setLastModifiedBy(user.getLastModifiedBy());

        ZonedDateTime newDate = ZonedDateTime.now(ZoneId.systemDefault());

        old.setLastModifiedDate(newDate.toString());
        return this.userRepository.save(old);

    }*/

}
