/*
package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDao;
import com.egiants.rlm.entity.User;
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


    private static final String EMAIL_ID = "xyz@gmail";
    private static final String FIRST_NAME = "firstName";

    private User user;
    private List<User> users;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {

        this.user = Mockito.mock(User.class);
        this.users = Arrays.asList(user);

        Mockito.doReturn(FIRST_NAME)
                .when(user)
                .getFirstName();

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetUsers() {
        Mockito.doReturn(this.users)
                .when(this.userDao)
                .getUsers();

        List<User> users = this.userService.getUsers();
        assertEquals(FIRST_NAME, users.get(0).getFirstName());
    }

    @Test
    public void testGetUser() {
        Mockito.doReturn(user)
                .when(this.userDao)
                .getUser(EMAIL_ID);

        User actualUser = this.userService.getUser(EMAIL_ID);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testCreateUser() {
        Mockito.doReturn(this.user)
                .when(this.userDao)
                .createUser(this.user);

        User actualUser = this.userService.createUser(user);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testCreateOrUpdateUser() {
        Mockito.doReturn(this.user)
                .when(this.userDao)
                .updateUser(this.user);

        User actualUser = this.userService.updateUser(user);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testDeleteUser() {
        Mockito.doNothing()
                .when(this.userDao)
                .deleteUser(EMAIL_ID);

        this.userService.deleteUser(EMAIL_ID);
        verify(userDao).deleteUser(EMAIL_ID);
    }

}
*/
