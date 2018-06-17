package com.egiants.rlm.service;

import com.egiants.rlm.dao.UserDemoGraphicDao;
import com.egiants.rlm.entity.UserDemoGraphic;

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

public class UserDemographicServiceTest {

    private static final String EMAIL_ID = "xyz@gmail";
    private static final String FIRST_NAME = "firstName";

    private UserDemoGraphic userdemogrpahic;
    private List<UserDemoGraphic> usersDemographic;

    @Mock
    private UserDemoGraphicDao userDemoGraphicDao;

    @InjectMocks
    private UserDemoGraphicServiceImpl userServiceDeoGraphicImpl;

    @Before
    public void setUp() throws Exception {

        this.userdemogrpahic = Mockito.mock(UserDemoGraphic.class);
        this.usersDemographic = Arrays.asList(userdemogrpahic);

        Mockito.doReturn(FIRST_NAME)
                .when(userdemogrpahic)
                .getFirstName();

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetUsers() {
        Mockito.doReturn(this.usersDemographic)
                .when(this.userDemoGraphicDao)
                .getUsers();

        List<UserDemoGraphic> usersDemoGraphicDao = this.userDemoGraphicDao.getUsers();
        assertEquals(FIRST_NAME, usersDemoGraphicDao.get(0).getFirstName());
    }

    @Test
    public void testGetUser() {
        Mockito.doReturn(userdemogrpahic)
                .when(this.userDemoGraphicDao)
                .getUser(EMAIL_ID);

        UserDemoGraphic actualUser = this.userServiceDeoGraphicImpl.getUser(EMAIL_ID);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testCreateUser() {
        Mockito.doReturn(this.userdemogrpahic)
                .when(this.userDemoGraphicDao)
                .createUser(this.userdemogrpahic);

        UserDemoGraphic actualUser = this.userServiceDeoGraphicImpl.createUser(userdemogrpahic);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testCreateOrUpdateUser() {
        Mockito.doReturn(this.userdemogrpahic)
                .when(this.userDemoGraphicDao)
                .createOrUpdateUser(this.userdemogrpahic);

        UserDemoGraphic actualUser = this.userServiceDeoGraphicImpl.createOrUpdateUser(userdemogrpahic);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
    }

    @Test
    public void testDeleteUser() {
        Mockito.doNothing()
                .when(this.userDemoGraphicDao)
                .deleteUser(EMAIL_ID);

        this.userServiceDeoGraphicImpl.deleteUser(EMAIL_ID);
        verify(userDemoGraphicDao).deleteUser(EMAIL_ID);
    }

}