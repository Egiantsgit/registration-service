package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.User;
import com.egiants.rlm.service.UserService;
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
@RequestMapping("/users")
@Api(value = "Registration", description = "Operations pertaining to users") // swagger annotation
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "List of Users")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get User with emailId")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable("emailId") String emailId) {

        return new ResponseEntity<>(this.userService.getUser(emailId), HttpStatus.OK);
    }

    @ApiOperation(value = "Add User")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(
            @PathVariable("emailId") String emailId, @RequestBody User user) {

        if (!emailId.equals(user.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }

        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update User")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> updateUser(
            @PathVariable("emailId") String emailId, @RequestBody User user) {

        if (!emailId.equals(user.getEmailId())) {
            throw new MismatchIdentifierException(emailId);
        }

        return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})

    public ResponseEntity<Void> deleteUser(@PathVariable("emailId") String emailId) {

        this.userService.deleteUser(emailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
