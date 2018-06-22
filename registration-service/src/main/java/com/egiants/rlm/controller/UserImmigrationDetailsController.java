package com.egiants.rlm.controller;

import com.egiants.rlm.Exceptions.UserNotFoundException;
import com.egiants.rlm.entity.UserImmigrationDetails;
import com.egiants.rlm.service.UserImmigrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/userImmigrationDetails")
public class UserImmigrationDetailsController {

    @Autowired
    private UserImmigrationDetailsService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<List<UserImmigrationDetails>> getAllUserImmigrationDetails() {
        return new ResponseEntity<>(service.getAllUserImmigrationDetails(), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{uuid}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserImmigrationDetails> getUserImmigrationDetails(@PathVariable("uuid") String uuid) {
        UserImmigrationDetails user = service.getUserImmigrationDetails(uuid);
        if (user == null)
            throw new UserNotFoundException("\"User with  UUID " + uuid + " doesn't exists\"");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserImmigrationDetails> createUserImmigrationDetails(@Valid @RequestBody UserImmigrationDetails userImmigrationDetails) {
        String uuid = userImmigrationDetails.getUuid();
        if (service.getUserImmigrationDetails(uuid) != null) {
            throw new UserNotFoundException("User with UUID " + uuid + " already exists");
        } else {
            UserImmigrationDetails savedUser = service.createUserImmigrationDetails(userImmigrationDetails);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{uuid}")
                    .buildAndExpand(savedUser.getUuid()).toUri();
            return ResponseEntity.created(location).build();
        }

    }


    @RequestMapping(value = "/users/{uuid}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserImmigrationDetails> createOrUpdateUserImmigrationDetails(@PathVariable("uuid") String uuid, @RequestBody UserImmigrationDetails userImmigrationDetails) {

        UserImmigrationDetails user = service.getUserImmigrationDetails(uuid);
        if (user == null) {
            throw new UserNotFoundException("User with  UUID " + uuid + " doesn't exists");
        }
        return new ResponseEntity<>(service.createOrUpdateUserImmigrationDetails(userImmigrationDetails), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/users/{uuid}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserImmigrationDetails> deleteUserImmigrationDetails(@PathVariable("uuid") String uuid) {

        UserImmigrationDetails user = service.getUserImmigrationDetails(uuid);
        if (user == null) {
            throw new UserNotFoundException("User with  UUID " + uuid + " doesn't exists");
        }
        service.deleteUserImmigrationDetails(uuid);
        return ResponseEntity.ok().build();
    }


}
