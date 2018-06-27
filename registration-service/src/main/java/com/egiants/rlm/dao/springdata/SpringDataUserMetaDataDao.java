package com.egiants.rlm.dao.springdata;

import com.egiants.rlm.dao.UserMetaDataDao;
import com.egiants.rlm.dao.config.DynamoDbConfig;
import com.egiants.rlm.entity.UserMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class SpringDataUserMetaDataDao implements UserMetaDataDao {

    @Autowired
    DynamoDbConfig dynamoDbConfig;
    @Autowired
    private UserMetaDataRepo userMetaDataRepo;

    @Override
    public List<UserMetaData> getUsersMetaData() {

        Iterable<UserMetaData> usersMetaData = this.userMetaDataRepo.findAll();

        return (List<UserMetaData>) usersMetaData;
    }

    @Override
    public UserMetaData getUserMetaData(String emailId) {
        // TODO: add Resource not found exception if user is null
        return this.userMetaDataRepo.findOne(emailId);

    }

    @Override
    public UserMetaData createUserMetaData(UserMetaData userMetaData) {

        UUID uuid = UUID.randomUUID();
        userMetaData.setUuid(uuid);
        return this.userMetaDataRepo.save(userMetaData);
    }

    @Override
    public UserMetaData updateUserMetaData(UserMetaData userMetaData) {
        //TODO: for now we will give UUID to UI and they will send it with out any modification
        return customUpdate(userMetaData);

    }

    @Override
    public void deleteUserMetaData(String emailId) {

        this.userMetaDataRepo.delete(emailId);
    }

    public UserMetaData customUpdate(UserMetaData userMetaData) {

        UserMetaData old = this.userMetaDataRepo.findOne(userMetaData.getEmailId());

		/* not changing EmailId, CreatedBy, UUID, CreatedDate */

        old.setFirstName(userMetaData.getFirstName());
        old.setLastName(userMetaData.getLastName());
        old.setRole(userMetaData.getRole());
        old.setLastModifiedBy(userMetaData.getLastModifiedBy());

        ZonedDateTime newDate = ZonedDateTime.now(ZoneId.systemDefault());

        old.setLastModifiedDate(newDate.toString());
        return this.userMetaDataRepo.save(old);

    }

}
