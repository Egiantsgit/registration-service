package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserMetaData;
import com.egiants.rlm.service.UserMetaDataService;
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
@RequestMapping("/usersMetaData")
@Api(value = "Registration", description = "Operations pertaining to users")
public class UserMetaDataController {

    @Autowired
    private UserMetaDataService userMetaDataService;


    @ApiOperation(value = "List of UsersMetaData")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserMetaData>> getUsersMetaData() {
        return new ResponseEntity<>(this.userMetaDataService
                .getUsersMetaData(), HttpStatus.OK);
    }


    @ApiOperation(value = "Get UserMetaData with emailId")
    @RequestMapping(value = "/userMetaData/{emailId:.+}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMetaData> getUserMetaData(
            @PathVariable("emailId") String emailId) {

        return new ResponseEntity<>(this.userMetaDataService
                .getUserMetaData(emailId), HttpStatus.OK);
    }

    @ApiOperation(value = "Add UserMetaData")
    @RequestMapping(value = "/userMetaData/{emailId:.+}", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMetaData> createUserMetaData(
            @PathVariable("emailId") String emailId, @RequestBody UserMetaData userMetaData) {

        if (!emailId.equals(userMetaData.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }

        return new ResponseEntity<>(this.userMetaDataService
                .createUserMetaData(userMetaData), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update UserMetaData")
    @RequestMapping(value = "/userMetaData/{emailId:.+}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserMetaData> updateUserMetaData(
            @PathVariable("emailId") String emailId, @RequestBody UserMetaData userMetaData) {

        if (!emailId.equals(userMetaData.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }

        return new ResponseEntity<>(this.userMetaDataService.updateUserMetaData(userMetaData), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Void> deleteUserMetaData(@PathVariable("emailId") String emailId) {

        this.userMetaDataService.deleteUserMetaData(emailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
