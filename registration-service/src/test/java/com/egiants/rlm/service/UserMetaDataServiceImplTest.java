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

import com.egiants.rlm.dao.UserMetaDataDao;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.impl.DefaultUserMetaDataService;

public class UserMetaDataServiceImplTest {
	
	 	private static final String EMAIL_ID = "sairam.mandadi46@gmail";
	    private static final String FIRST_NAME = "firstName";

	    private UserMetaData userMetaData;
	    private List<UserMetaData> usersMetaData;

	    @Mock
	    private UserMetaDataDao userMetaDataDao;

	    @InjectMocks
	    private DefaultUserMetaDataService defaultUserMetaDataService;
	    
	    @Before
	    public void setUp() throws Exception {

	        this.userMetaData = Mockito.mock(UserMetaData.class);
	        this.usersMetaData = Arrays.asList(userMetaData);

	        Mockito.doReturn(FIRST_NAME)
	                .when(userMetaData)
	                .getFirstName();

	        MockitoAnnotations.initMocks(this);

	    }

	    @Test
	    public void testGetUsersMetaData() {
	        Mockito.doReturn(this.usersMetaData)
	                .when(this.userMetaDataDao)
	                .getUsersMetaData();

	        List<UserMetaData> usersMetaData = this.defaultUserMetaDataService.getUsersMetaData();
	        assertEquals(FIRST_NAME, usersMetaData.get(0).getFirstName());
	    }

	    

		

	    
	    @Test
	    public void testGetUserMetaData() {
	        Mockito.doReturn(userMetaData)
	                .when(this.userMetaDataDao)
	                .getUserMetaData(EMAIL_ID);

	        UserMetaData actualUserMetaData = this.defaultUserMetaDataService.getUserMetaData(EMAIL_ID);
	        assertEquals(FIRST_NAME, actualUserMetaData.getFirstName());
	    }

	    @Test
	    public void testCreateUserMetaData() {
	        Mockito.doReturn(this.userMetaData)
	                .when(this.userMetaDataDao)
	                .createUserMetaData(this.userMetaData);

	        UserMetaData actualUserMetaData = this.defaultUserMetaDataService.createUserMetaData(userMetaData);
	        assertEquals(FIRST_NAME, actualUserMetaData.getFirstName());
	    }


	    
	    
	    @Test
	    public void testUpdateUserMetaData() {
	        Mockito.doReturn(this.userMetaData)
	                .when(this.userMetaDataDao)
	                .updateUserMetaData(this.userMetaData);

	        UserMetaData actualUserMetaData = this.defaultUserMetaDataService.updateUserMetaData(userMetaData);
	        assertEquals(FIRST_NAME, actualUserMetaData.getFirstName());
	    }

	    @Test
	    public void testDeleteUserMetaData() {
	        Mockito.doNothing()
	                .when(this.userMetaDataDao)
	                .deleteUserMetaData(EMAIL_ID);

	        this.defaultUserMetaDataService.deleteUserMetaData(EMAIL_ID);
	        verify(userMetaDataDao).deleteUserMetaData(EMAIL_ID);
	    }
	

}
