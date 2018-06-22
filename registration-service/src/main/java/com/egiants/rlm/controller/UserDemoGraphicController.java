package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserDemoGraphics;
import com.egiants.rlm.service.UserDemoGraphicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usersDemoGraphics")
@Api(value = "Registration", description = "Operations pertaining to UsersDemoGraphics")
public class UserDemoGraphicController {

    @Autowired
    private UserDemoGraphicService userDemoGraphicService;

    @ApiOperation(value = "List of UsersDemoGraphics info")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDemoGraphics>> getUsersDemoGraphics() {
        return new ResponseEntity<>(this.userDemoGraphicService.getUsersDemoGraphics(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get UserDemoGraphics with email")
    @RequestMapping(value = "/userDemoGraphicInfo/{emailId:.+}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDemoGraphics> getUserDemoGraphicInfo(@PathVariable("emailId") String emailId) {

        return new ResponseEntity<>(this.userDemoGraphicService.getUserDemoGraphicInfo(emailId), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDemoGraphics> createUserDemoGraphicInfo(
            @PathVariable("emailId") String emailId,
            @RequestBody UserDemoGraphics userDemoGraphics) {

        if (!emailId.equals(userDemoGraphics.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }
        return new ResponseEntity<>(this.userDemoGraphicService
                .createUserDemoGraphicInfo(userDemoGraphics), HttpStatus.CREATED);
    }

    @ApiOperation(value = "update a user")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDemoGraphics> updateUserDemoGraphicInfo(
            @PathVariable("emailId") String emailId,
            @RequestBody UserDemoGraphics userDemoGraphics) {

        if (!emailId.equals(userDemoGraphics.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }
        return new ResponseEntity<>(this.userDemoGraphicService
                .updateUserDemoGraphicInfo(userDemoGraphics), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete a user")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> deleteUserDemoGraphicInfo(
            @PathVariable("emailId") String emailId) {

        this.userDemoGraphicService.deleteUserDemoGraphicInfo(emailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
