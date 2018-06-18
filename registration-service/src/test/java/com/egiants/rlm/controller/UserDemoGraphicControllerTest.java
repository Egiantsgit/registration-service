package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.entity.UserDemoGraphic;
import com.egiants.rlm.service.UserDemoGraphicService;
import com.egiants.rlm.service.UserService;
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

public class UserDemoGraphicControllerTest {

    private static final String EMAIL_ID = "xyz@gmail.com";
    private static final String MISMATCH_EMAIL_ID = "mismatchEmailId@gmail.com";
    private static final String FIRST_NAME = "firstName";

    private UserDemoGraphic userdemogrpahic;
    private List<UserDemoGraphic> usersDemographic;

    @Mock
    private UserDemoGraphicService userDemoGraphicService;

    @InjectMocks
    private UserDemoGraphicController userDemoGraphicController;

    @Before
    public void setUp() throws Exception {

        this.userdemogrpahic = Mockito.mock(UserDemoGraphic.class);
        this.usersDemographic = Arrays.asList(userdemogrpahic);

        Mockito.doReturn(FIRST_NAME)
                .when(userdemogrpahic)
                .getFirstName();
        Mockito.doReturn(EMAIL_ID)
                .when(this.userdemogrpahic)
                .getEmailId();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        Mockito.doReturn(this.usersDemographic)
                .when(this.userDemoGraphicService)
                .getUsers();

        ResponseEntity<List<UserDemoGraphic>> responseEntity = this.userDemoGraphicController.getUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().get(0).getFirstName());
    }

    @Test
    public void testGetUser() {
        Mockito.doReturn(userdemogrpahic)
                .when(this.userDemoGraphicService)
                .getUser(EMAIL_ID);

        ResponseEntity<UserDemoGraphic> responseEntity = this.userDemoGraphicController.getUser(EMAIL_ID);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test
    public void testCreateUser() {
        Mockito.doReturn(this.userdemogrpahic)
                .when(this.userDemoGraphicService)
                .createUser(this.userdemogrpahic);

        ResponseEntity<UserDemoGraphic> responseEntity =
                this.userDemoGraphicController.createUser(EMAIL_ID, userdemogrpahic);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testCreateUserException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.userdemogrpahic)
                .getEmailId();

        this.userDemoGraphicController.createUser(EMAIL_ID, userdemogrpahic);
    }

    @Test
    public void testUpdateUser() {
        Mockito.doReturn(this.userdemogrpahic)
                .when(this.userDemoGraphicService)
                .createOrUpdateUser(this.userdemogrpahic);

        ResponseEntity<UserDemoGraphic> responseEntity =
                this.userDemoGraphicController.createOrUpdateUser(EMAIL_ID, userdemogrpahic);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testUpdateUserException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.userdemogrpahic)
                .getEmailId();

        this.userDemoGraphicController.createOrUpdateUser(EMAIL_ID, userdemogrpahic);
    }

    @Test
    public void testDeleteUser() {
        Mockito.doNothing()
                .when(this.userDemoGraphicService)
                .deleteUser(EMAIL_ID);

        ResponseEntity<Void> responseEntity =
                this.userDemoGraphicController.deleteUser(EMAIL_ID);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

}