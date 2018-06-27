/*
package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.User;
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

public class UserControllerTest {

    private static final String EMAIL_ID = "xyz@gmail.com";
    private static final String MISMATCH_EMAIL_ID = "mismatchEmailId@gmail.com";
    private static final String FIRST_NAME = "firstName";

    private User user;
    private List<User> users;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Exception {

        this.user = Mockito.mock(User.class);
        this.users = Arrays.asList(user);

        Mockito.doReturn(FIRST_NAME)
                .when(user)
                .getFirstName();
        Mockito.doReturn(EMAIL_ID)
                .when(this.user)
                .getEmailId();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUsers() {
        Mockito.doReturn(this.users)
                .when(this.userService)
                .getUsers();

        ResponseEntity<List<User>> responseEntity = this.userController.getUsers();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().get(0).getFirstName());
    }

    @Test
    public void testGetUser() {
        Mockito.doReturn(user)
                .when(this.userService)
                .getUser(EMAIL_ID);

        ResponseEntity<User> responseEntity = this.userController.getUser(EMAIL_ID);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test
    public void testCreateUser() {
        Mockito.doReturn(this.user)
                .when(this.userService)
                .createUser(this.user);

        ResponseEntity<User> responseEntity =
                this.userController.createUser(EMAIL_ID, user);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testCreateUserException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.user)
                .getEmailId();

        this.userController.createUser(EMAIL_ID, user);
    }

    @Test
    public void testUpdateUser() {
        Mockito.doReturn(this.user)
                .when(this.userService)
                .updateUser(this.user);

        ResponseEntity<User> responseEntity =
                this.userController.updateUser(EMAIL_ID, user);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(FIRST_NAME, responseEntity.getBody().getFirstName());
    }

    @Test(expected = MismatchIdentifierException.class)
    public void testUpdateUserException() {
        Mockito.doReturn(MISMATCH_EMAIL_ID)
                .when(this.user)
                .getEmailId();

        this.userController.updateUser(EMAIL_ID, user);
    }

    @Test
    public void testDeleteUser() {
        Mockito.doNothing()
                .when(this.userService)
                .deleteUser(EMAIL_ID);

        ResponseEntity<Void> responseEntity =
                this.userController.deleteUser(EMAIL_ID);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

}
*/
