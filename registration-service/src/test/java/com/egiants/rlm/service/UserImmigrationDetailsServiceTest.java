package com.egiants.rlm.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.egiants.rlm.dao.UserImmigrationDetailsDao;
import com.egiants.rlm.entity.UserImmigrationDetails;

public class UserImmigrationDetailsServiceTest {

	private static final String UUID = "1234";
    private static final String COUNTRY_OF_BIRTH = "india";

    private UserImmigrationDetails userImmigrationDetails;
    private List<UserImmigrationDetails> userImmigrationDetailsList;

    @Mock
    private UserImmigrationDetailsDao dao;

    @InjectMocks
    private UserImmigrationDetailsServiceImpl service;

    @Before
    public void setUp() throws Exception {

        this.userImmigrationDetails = Mockito.mock(UserImmigrationDetails.class);
        this.userImmigrationDetailsList = Arrays.asList(userImmigrationDetails);

        Mockito.doReturn(COUNTRY_OF_BIRTH)
                .when(userImmigrationDetails)
                .getCountryOfBirth();

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetAllUsersImmigrationDetails() {
        Mockito.doReturn(this.userImmigrationDetailsList)
                .when(this.dao)
                .getAllUserImmigrationDetails();

        List<UserImmigrationDetails> users = this.service.getAllUserImmigrationDetails();
        assertEquals(COUNTRY_OF_BIRTH, users.get(0).getCountryOfBirth());
    }

    @Test
    public void testGetUserImmigrationDetails() {
        Mockito.doReturn(userImmigrationDetails)
                .when(this.dao)
                .getUserImmigrationDetails(UUID);

        UserImmigrationDetails actualUser = this.service.getUserImmigrationDetails(UUID);
        assertEquals(COUNTRY_OF_BIRTH, actualUser.getCountryOfBirth());
    }

    @Test
    public void testCreateUserImmigrationDetails() {
        Mockito.doReturn(this.userImmigrationDetails)
                .when(this.dao)
                .createUserImmigrationDetails(this.userImmigrationDetails);

        UserImmigrationDetails actualUser = this.service.createUserImmigrationDetails(userImmigrationDetails);
        assertEquals(COUNTRY_OF_BIRTH, actualUser.getCountryOfBirth());
    }

    @Test
    public void testCreateOrUpdateUserImmigrationDetails() {
        Mockito.doReturn(this.userImmigrationDetails)
                .when(this.dao)
                .createOrUpdateUserImmigrationDetails(this.userImmigrationDetails);

        UserImmigrationDetails actualUser = this.service.createOrUpdateUserImmigrationDetails(this.userImmigrationDetails);
        assertEquals(COUNTRY_OF_BIRTH, actualUser.getCountryOfBirth());
    }

    @Test
    public void testDeleteUserImmigrationDetails() {
        Mockito.doNothing()
                .when(this.dao)
                .deleteUserImmigrationDetails(UUID);;

        this.service.deleteUserImmigrationDetails(UUID);;
        verify(dao).deleteUserImmigrationDetails(UUID);
    }

}
