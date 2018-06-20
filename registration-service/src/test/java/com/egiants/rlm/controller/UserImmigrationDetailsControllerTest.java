package com.egiants.rlm.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.egiants.rlm.entity.UserImmigrationDetails;
import com.egiants.rlm.service.UserImmigrationDetailsService;

public class UserImmigrationDetailsControllerTest {
	

	private static final String COUNTRY_OF_BIRTH = "india";
    private static final String UUID = "123";

    private UserImmigrationDetails userImmigrationDetails;
    private List<UserImmigrationDetails> usersImmigrationDetailsList;

    @Mock
    private UserImmigrationDetailsService service;

    @InjectMocks
    private UserImmigrationDetailsController controller;

    @Before
    public void setUp() throws Exception {

        this.userImmigrationDetails = Mockito.mock(UserImmigrationDetails.class);
        this.usersImmigrationDetailsList = Arrays.asList(userImmigrationDetails);

        Mockito.doReturn(COUNTRY_OF_BIRTH)
                .when(userImmigrationDetails)
                .getCountryOfBirth();
        Mockito.doReturn(UUID)
                .when(this.userImmigrationDetails)
                .getUuid();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsersImmigrationsDetails() {
        Mockito.doReturn(this.usersImmigrationDetailsList)
                .when(this.service)
                .getAllUserImmigrationDetails();

        ResponseEntity<List<UserImmigrationDetails>> responseEntity = this.controller.getAllUserImmigrationDetails();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(COUNTRY_OF_BIRTH , responseEntity.getBody().get(0).getCountryOfBirth());
    }

    @Test
    public void testGetUserImmigrationDetails() {
        Mockito.doReturn(userImmigrationDetails)
                .when(this.service)
                .getUserImmigrationDetails(UUID);

        ResponseEntity<UserImmigrationDetails> responseEntity = this.controller.getUserImmigrationDetails(UUID);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(COUNTRY_OF_BIRTH, responseEntity.getBody().getCountryOfBirth());
    }
    
    @Ignore
    @Test
    public void testCreateUserImmigrationDetails() {
        Mockito.doReturn(this.userImmigrationDetails)
                .when(this.service)
                .createUserImmigrationDetails(this.userImmigrationDetails);

        ResponseEntity<UserImmigrationDetails> responseEntity =
                this.controller.createUserImmigrationDetails(this.userImmigrationDetails);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(COUNTRY_OF_BIRTH, responseEntity.getBody().getCountryOfBirth());
    }

    
    @Ignore
    @Test
    public void testCreateOrUpdateUserImmigrationDetails() {
        Mockito.doReturn(this.userImmigrationDetails)
                .when(this.service)
                .createOrUpdateUserImmigrationDetails(this.userImmigrationDetails);
               

        ResponseEntity<UserImmigrationDetails> responseEntity =
                this.controller.createOrUpdateUserImmigrationDetails(UUID, this.userImmigrationDetails);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(COUNTRY_OF_BIRTH, responseEntity.getBody().getCountryOfBirth());
    }

   
    @Ignore
    @Test
    public void testDeleteUserImmigrationDetails() {
        Mockito.doNothing()
                .when(this.service)
                .deleteUserImmigrationDetails(UUID);;

        ResponseEntity<UserImmigrationDetails> responseEntity =
                this.controller.deleteUserImmigrationDetails(UUID);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

}
