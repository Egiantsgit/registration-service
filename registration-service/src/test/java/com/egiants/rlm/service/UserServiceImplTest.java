
package com.egiants.rlm.service;

import com.egiants.rlm.dao.springdata.SpringDataUserMetaDataDao;
import com.egiants.rlm.dao.springdata.SpringDataUserRegistrationDao;
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
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

	private static final String EMAIL_ID = "sairam.mandadi64@gmail.com";
	private UserPersonalDetails userPersonalDetails;
	private User user;
	private List<User> users;
	private UserMetaData userMetaData;
	private List<UserMetaData> usersMetaData;

	@Mock
	private SpringDataUserRegistrationDao userRegistrationDao;
	@Mock
	private SpringDataUserMetaDataDao userMetaDataDao;

	@InjectMocks
	private DefaultUserRegistrationService userRegistrationService;
	@InjectMocks
	private DefaultUserMetaDataService userMetaDataService;


	@Before
	public void setUp() throws Exception {
		this.userPersonalDetails = Mockito.mock(UserPersonalDetails.class);
		this.user = Mockito.mock(User.class);
		this.users = Arrays.asList(user);
		this.userMetaData = Mockito.mock(UserMetaData.class);

		Mockito.doReturn(this.userPersonalDetails).when(user).getUserPersonalDetails();
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testGetUsers() {
		Mockito.doReturn(this.users).when(this.userRegistrationDao).getUsers();
		Mockito.doReturn(this.usersMetaData).when(this.userMetaDataDao).getUsersMetaData();


		
		List<User> users = this.userRegistrationService.getUsers();
		List<UserMetaData> usersMetaData = this.userMetaDataService.getUsersMetaData();

		
		assertEquals(userPersonalDetails, users.get(0).getUserPersonalDetails());
		assertEquals(userMetaData, usersMetaData.get(0));

		
	}

	@Test
	public void testGetUser() {
		Mockito.doReturn(this.userMetaData).when(this.userMetaDataService).getUserMetaData(EMAIL_ID);
		Mockito.doReturn(this.user).when(this.userRegistrationDao).getUser(EMAIL_ID);

		User actualUser = this.userRegistrationService.getUser(EMAIL_ID);
		UserMetaData actualUserMetaData= this.userMetaDataService.getUserMetaData(EMAIL_ID);
		assertEquals(userPersonalDetails, actualUser.getUserPersonalDetails());
		assertEquals(userMetaData,actualUserMetaData);
	}

	@Test
	public void testCreateUser() {
		Mockito.doReturn(this.userMetaData).when(this.userMetaDataDao).createUserMetaData(userMetaData);
		Mockito.doReturn(this.user).when(this.userRegistrationDao).createUser(EMAIL_ID, user);
		
		

		User actualUsers = this.userRegistrationService.createUser(EMAIL_ID, user);
		UserMetaData actualUsersMetaData = this.userMetaDataService.createUserMetaData(userMetaData);

		assertEquals(userPersonalDetails, actualUsers.getUserPersonalDetails());
		assertEquals(userMetaData, actualUsersMetaData);


	}

	@Test
	public void testUpdateUser() {
		Mockito.doReturn(this.user).when(this.userRegistrationDao).updateUser(EMAIL_ID, user);
		Mockito.doReturn(this.userMetaData).when(this.userMetaDataDao).updateUserMetaData( userMetaData);


		User actualUsers = this.userRegistrationService.updateUser(EMAIL_ID, user);
		UserMetaData actualUsersMetaData = this.userMetaDataService.updateUserMetaData(userMetaData);

		assertEquals(userPersonalDetails, actualUsers.getUserPersonalDetails());
		assertEquals(userMetaData, actualUsersMetaData);


	}

	@Test
	public void testDeleteUser() {
		Mockito.doNothing().when(this.userRegistrationDao).deleteUser(EMAIL_ID);
		Mockito.doNothing().when(this.userMetaDataDao).deleteUserMetaData(EMAIL_ID);


		this.userRegistrationService.deleteUser(EMAIL_ID);
		this.userMetaDataService.deleteUserMetaData(EMAIL_ID);
		verify(userRegistrationDao).deleteUser(EMAIL_ID);
		verify(userMetaDataDao).deleteUserMetaData(EMAIL_ID);

	}

}
