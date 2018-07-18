
package com.egiants.rlm.controller;

import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.entity.UserPersonalDetails;
import com.egiants.rlm.service.impl.DefaultUserMetaDataService;
import com.egiants.rlm.service.impl.DefaultUserRegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserControllerTest  {

	private static final String EMAIL_ID = "sairam.mandadi46@gmail.com";
	private UserPersonalDetails userPersonalDetails;
    private User user;
    private List<User> users;
	private UserMetaData userMetaData;
	private List<UserMetaData> usersMetaData;



    @Mock
    private DefaultUserRegistrationService userRegistrationService;
    @Mock
    private DefaultUserMetaDataService userMetaDataService;

    @InjectMocks
    private UserRegistrationController userRegistrationController;
    @InjectMocks
    private UserMetaDataController UserMetaDataController;

    @Before
    public void setUp() throws Exception {

    	this.userPersonalDetails = Mockito.mock(UserPersonalDetails.class);
        this.user = Mockito.mock(User.class);
        this.users = Arrays.asList(user);
        this.userMetaData =Mockito.mock(UserMetaData.class);
        

        Mockito.doReturn(this.userPersonalDetails)
                .when(user)
                .getUserPersonalDetails();
        
        /*Mockito.doReturn(EMAIL_ID).when(this.userPersonalDetails).getEmailId();*/

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        Mockito.doReturn(this.users)
                .when(this.userRegistrationService)
                .getUsers();

        ResponseEntity<List<User>> responseEntity =this.userRegistrationController.getUsers();
        ResponseEntity<List<UserMetaData>> responseEntityMetaData =this.UserMetaDataController.getUsersMetaData();


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(HttpStatus.OK, responseEntityMetaData.getStatusCode());

        assertEquals(this.userPersonalDetails, responseEntity.getBody().get(0).getUserPersonalDetails());
        assertEquals(usersMetaData, responseEntityMetaData.getBody());

    }
    
    @Test
    public void testGetUser() {
    	
    	Mockito.doReturn(user)
    		.when(this.userRegistrationService)
    		.getUser(EMAIL_ID);
    	ResponseEntity<User>responseEntity = this.userRegistrationController.getUser(EMAIL_ID);
    	ResponseEntity<UserMetaData>responseEntityMetaData = this.UserMetaDataController.getUserMetaData(EMAIL_ID);

    	
    	 assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	 assertEquals(HttpStatus.OK, responseEntityMetaData.getStatusCode());

         assertEquals(this.userPersonalDetails, responseEntity.getBody().getUserPersonalDetails());	
         assertEquals(this.userMetaData, responseEntityMetaData.getBody());	

    }
   

    @Test
    public void testCreateUser() {
        Mockito.doReturn(this.users)
                .when(this.userRegistrationService)
                .createUser(EMAIL_ID, user);

        ResponseEntity<User> responseEntity = this.userRegistrationController.createUser(EMAIL_ID, user);
        ResponseEntity<UserMetaData> responseEntityMetaData = this.UserMetaDataController.createUserMetaData(EMAIL_ID, userMetaData);


        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(HttpStatus.CREATED, responseEntityMetaData.getStatusCode());

        assertEquals(this.userPersonalDetails, responseEntity.getBody().getUserPersonalDetails());
        assertEquals(this.userMetaData, responseEntityMetaData.getBody());

    }

    @Test
    public void testUpdateUser() {
        Mockito.doReturn(this.user)
                .when(this.userRegistrationService)
                .updateUser(EMAIL_ID,user);

        ResponseEntity<User> responseEntity =this.userRegistrationController.updateUser(EMAIL_ID,user);
        ResponseEntity<UserMetaData> responseEntityMetaData =this.UserMetaDataController.updateUserMetaData(EMAIL_ID,userMetaData);


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(HttpStatus.OK, responseEntityMetaData.getStatusCode());

        assertEquals(this.userPersonalDetails, responseEntity.getBody().getUserPersonalDetails());
        assertEquals(this.userMetaData, responseEntityMetaData.getBody());

    }

  @Test
    public void testDeleteUser() {
        Mockito.doReturn(user)
                .when(this.userRegistrationService)
                .deleteUser(EMAIL_ID);
		ResponseEntity<Void>responseEntity= this.userRegistrationController.deleteUser(EMAIL_ID);
		ResponseEntity<Void>responseEntityMetaData= this.UserMetaDataController.deleteUserMetaData(EMAIL_ID);

        
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertEquals(HttpStatus.NO_CONTENT, responseEntityMetaData.getStatusCode());

        
      //  assertEquals(this.userPersonalDetails, responseEntity.getBody().getUserPersonalDetails());
        
    }

   /* @Test
    public void testUpdateUserPersonalDetails() {
        Mockito.doReturn(this.userPersonalDetails)
                .when(this.defaultUserRegistrationService)
                .updateUserPersonalDetails(this.userPersonalDetails);

        ResponseEntity<User> responseEntity =
                this.userRegistrationController.updateUserPersonalDetails(EMAIL_ID, userPersonalDetails);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testUpdateUserException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.userPersonalDetails)
                .getEmailId();

        this.userRegistrationController.updateUserPersonalDetails(EMAIL_ID, userPersonalDetails);
    }

    @Test
    public void testDeleteUserPersonalDetails() {
        Mockito.doNothing()
                .when(this.defaultUserRegistrationService)
                .deleteUserPersonalDetails(EMAIL_ID);

        ResponseEntity<Void> responseEntity =
                this.userRegistrationController.deleteUser(EMAIL_ID);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }*/

}