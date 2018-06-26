/*
package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserDemoGraphics;
import com.egiants.rlm.service.UserDemoGraphicService;
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

    private UserDemoGraphics userDemoGraphics;
    private List<UserDemoGraphics> usersDemoGraphics;

    @Mock
    private UserDemoGraphicService userDemoGraphicService;

    @InjectMocks
    private UserDemoGraphicController userDemoGraphicController;

    @Before
    public void setUp() throws Exception {

        this.userDemoGraphics = Mockito.mock(UserDemoGraphics.class);
        this.usersDemoGraphics = Arrays.asList(userDemoGraphics);

        Mockito.doReturn(FIRST_NAME).when(userDemoGraphics).getFirstName();
        Mockito.doReturn(EMAIL_ID).when(this.userDemoGraphics).getEmailId();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsersDemoGraphics() {
        Mockito.doReturn(this.usersDemoGraphics)
                .when(this.userDemoGraphicService)
                .getUsersDemoGraphics();

        ResponseEntity<List<UserDemoGraphics>> responseEntity =
                this.userDemoGraphicController.getUsersDemoGraphics();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().get(0).getFirstName());
    }

    @Test
    public void testGetUserDemoGraphicInfo() {
        Mockito.doReturn(userDemoGraphics)
                .when(this.userDemoGraphicService)
                .getUserDemoGraphicInfo(EMAIL_ID);

        ResponseEntity<UserDemoGraphics> responseEntity =
                this.userDemoGraphicController.getUserDemoGraphicInfo(EMAIL_ID);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test

    public void testCreateUserDemoGraphicInfo() {
        Mockito.doReturn(this.userDemoGraphics)
                .when(this.userDemoGraphicService)
                .createUserDemoGraphicInfo(userDemoGraphics);

        ResponseEntity<UserDemoGraphics> responseEntity =
                this.userDemoGraphicController.createUserDemoGraphicInfo(
                        EMAIL_ID, userDemoGraphics);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testCreateUserDemoGraphicInfoException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID).when(this.userDemoGraphics).getEmailId();

        this.userDemoGraphicController.createUserDemoGraphicInfo(EMAIL_ID, userDemoGraphics);
    }

    @Test
    public void testUpdateUserDemoGraphicInfo() {
        Mockito.doReturn(this.userDemoGraphics)
                .when(this.userDemoGraphicService)
                .updateUserDemoGraphicInfo(userDemoGraphics);

        ResponseEntity<UserDemoGraphics> responseEntity = this.userDemoGraphicController
                .updateUserDemoGraphicInfo(EMAIL_ID, userDemoGraphics);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }


    @Test(expected = MismatchIdentifierException.class)
    public void testUpdateUserDemoGraphicInfoException() {

        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.userDemoGraphics)
                .getEmailId();

        this.userDemoGraphicController.updateUserDemoGraphicInfo(
                EMAIL_ID, userDemoGraphics);
    }

    @Test
    public void testDeleteUserDemoGraphicInfo() {
        Mockito.doNothing()
                .when(this.userDemoGraphicService)
                .deleteUserDemoGraphicInfo(EMAIL_ID);

        ResponseEntity<Void> responseEntity =
                this.userDemoGraphicController.deleteUserDemoGraphicInfo(EMAIL_ID);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

}*/
