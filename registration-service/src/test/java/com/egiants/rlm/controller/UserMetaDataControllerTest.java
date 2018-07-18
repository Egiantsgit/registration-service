package com.egiants.rlm.controller;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.impl.DefaultUserMetaDataService;

public class UserMetaDataControllerTest {
	
	
		private static final String EMAIL_ID = "sairam.mandadi46@gmail.com";
	    private static final String MISMATCH_EMAIL_ID = "mismatchEmailId@gmail.com";
	    private static final String FIRST_NAME = "firstName";
	
	
	private UserMetaData userMetaData;
	private List<UserMetaData> usersMetaData;
	
	@Mock
	private DefaultUserMetaDataService defaultUserMetaDataService;
	
	
	@InjectMocks
	private UserMetaDataController userMetaDataController;
	

	@Before
	public void setUp() throws Exception {
		this.userMetaData=Mockito.mock(UserMetaData.class);
		this.usersMetaData=Arrays.asList(userMetaData);
		
		Mockito.doReturn(FIRST_NAME)
			.when(userMetaData)
			.getFirstName();
		Mockito.doReturn(EMAIL_ID)
			.when(this.userMetaData)
			.getEmailId();
			
			MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUsersMetaData() {
		Mockito.doReturn(this.usersMetaData)
			.when(this.defaultUserMetaDataService)
			.getUsersMetaData();
		
		  ResponseEntity<List<UserMetaData>> responseEntity = this.userMetaDataController.getUsersMetaData();

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(FIRST_NAME, responseEntity.getBody().get(0).getFirstName());		
	}
	
	
@After
public void tearDown()throws Exception{
	
}
	  @Test
	    public void testGetUserMetaData() {
	        Mockito.doReturn(userMetaData)
	                .when(this.defaultUserMetaDataService)
	                .getUserMetaData(EMAIL_ID);

	        ResponseEntity<UserMetaData> responseEntity = this.userMetaDataController.getUserMetaData(EMAIL_ID);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
	    }
	  
	  @Test
	    public void testCreateUserMetaData() {
	        Mockito.doReturn(this.userMetaData)
	                .when(this.defaultUserMetaDataService)
	                .createUserMetaData(this.userMetaData);

	        ResponseEntity<UserMetaData> responseEntity =
	                this.userMetaDataController.createUserMetaData(EMAIL_ID, userMetaData);

	        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
	    }
	  @Test(expected = MismatchIdentifierException.class)
	    public void testCreateUserMetaDataException() {
	        Mockito.doReturn(MISMATCH_EMAIL_ID)
	                .when(this.userMetaData)
	                .getEmailId();

	        this.userMetaDataController.createUserMetaData(EMAIL_ID, userMetaData);
	    }
	  
	  @Test
	    public void testUpdateUserMetaData() {
	        Mockito.doReturn(this.userMetaData)
	                .when(this.defaultUserMetaDataService)
	                .updateUserMetaData(this.userMetaData);

	        ResponseEntity<UserMetaData> responseEntity =
	                this.userMetaDataController.updateUserMetaData(EMAIL_ID, userMetaData);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
	    }

	    @Test(expected = MismatchIdentifierException.class)
	    public void testUpdateUserMetaDataException() {
	        Mockito.doReturn(MISMATCH_EMAIL_ID)
	                .when(this.userMetaData)
	                .getEmailId();

	        this.userMetaDataController.updateUserMetaData(EMAIL_ID, userMetaData);
	    }
	    @Test
	    public void testDeleteUserMetaData() {
	        Mockito.doNothing()
	                .when(this.defaultUserMetaDataService)
	                .deleteUserMetaData(EMAIL_ID);

	        ResponseEntity<Void> responseEntity =
	                this.userMetaDataController.deleteUserMetaData(EMAIL_ID);

	        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	    }

	  
	

}
