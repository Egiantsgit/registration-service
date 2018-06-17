package com.egiants.rlm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.rlm.Exceptions.MismatchIdentifierException;
import com.egiants.rlm.entity.UserDemoGraphic;
import com.egiants.rlm.service.UserDemoGraphicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userDemoGrpahics")
@Api(value = "Registration", description = "Operations pertaining to users") 
public class UserDemoGraphicController {

	@Autowired
	private UserDemoGraphicService UserDemoGraphicService;

	@ApiOperation(value = "view list of users")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDemoGraphic>> getUsers() {
		return new ResponseEntity<>(this.UserDemoGraphicService.getUsers(), HttpStatus.OK);
	}

	@ApiOperation(value = "search a user with email")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> getUser(@PathVariable("emailId") String emailId) {

		return new ResponseEntity<>(this.UserDemoGraphicService.getUser(emailId), HttpStatus.OK);
	}

	@ApiOperation(value = "Add a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> createUser(@PathVariable("emailId") String emailId,
			@RequestBody UserDemoGraphic user) {

		  if (!emailId.equals(user.getEmailId())) {
	            throw new MismatchIdentifierException(emailId);
	        }
		return new ResponseEntity<>(this.UserDemoGraphicService.createUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "update a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> createOrUpdateUser(@PathVariable("emailId") String emailId,
			@RequestBody UserDemoGraphic user) {

		  if (!emailId.equals(user.getEmailId())) {
	            throw new MismatchIdentifierException(emailId);
	        }
		return new ResponseEntity<>(this.UserDemoGraphicService.createOrUpdateUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "delete a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteUser(@PathVariable("emailId") String emailId) {

		this.UserDemoGraphicService.deleteUser(emailId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
