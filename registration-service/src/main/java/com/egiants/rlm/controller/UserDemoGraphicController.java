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
@RequestMapping("/usersDemoGraphics")
@Api(value = "Registration", description = "Operations pertaining to UsersDemoGraphics")
public class UserDemoGraphicController {

	@Autowired
	private UserDemoGraphicService UserDemoGraphicService;

	@ApiOperation(value = "List of UsersDemoGraphics info")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDemoGraphic>> getUsersDemoGraphics() {
		return new ResponseEntity<>(this.UserDemoGraphicService.getUsersDemoGraphics(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get UserDemoGraphics with email")
	@RequestMapping(value = "/userDemoGraphicInfo/{emailId:.+}",
			method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> getUserDemoGraphicInfo(@PathVariable("emailId") String emailId) {

		return new ResponseEntity<>(this.UserDemoGraphicService.getUserDemoGraphicInfo(emailId), HttpStatus.OK);
	}

	@ApiOperation(value = "Add a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> createUserDemoGraphicInfo(@PathVariable("emailId") String emailId,
			@RequestBody UserDemoGraphic userDemoGraphic) {

		  if (!emailId.equals(userDemoGraphic.getEmailId())) {
	            throw new MismatchIdentifierException(emailId);
	        }
		return new ResponseEntity<>(this.UserDemoGraphicService.createUserDemoGraphicInfo(userDemoGraphic), HttpStatus.CREATED);
	}

	@ApiOperation(value = "update a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDemoGraphic> updateUserDemoGraphicInfo(@PathVariable("emailId") String emailId,
			@RequestBody UserDemoGraphic userDemoGraphic) {

		  if (!emailId.equals(userDemoGraphic.getEmailId())) {
	            throw new MismatchIdentifierException(emailId);
	        }
		return new ResponseEntity<>(this.UserDemoGraphicService.updateUserDemoGraphicInfo(userDemoGraphic), HttpStatus.CREATED);
	}

	@ApiOperation(value = "delete a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteUserDemoGraphicInfo(@PathVariable("emailId") String emailId) {

		this.UserDemoGraphicService.deleteUserDemoGraphicInfo(emailId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
