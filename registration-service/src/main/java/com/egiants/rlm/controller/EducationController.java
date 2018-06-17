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

import com.egiants.rlm.entity.Education;
import com.egiants.rlm.service.EducationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController 
@RequestMapping("/education") 
@Api(value = "Registration", description = "Operations pertaining to users") 
public class EducationController {

	@Autowired
	private EducationService educationService;

	@ApiOperation(value = "view list of users")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Education>> getUsers() {
		return new ResponseEntity<>(this.educationService.getUsers(), HttpStatus.OK);
	}

	@ApiOperation(value = "search a user with email")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Education> getUser(@PathVariable("emailId") String emailId) {

		return new ResponseEntity<>(this.educationService.getUser(emailId), HttpStatus.OK);
	}

	// swagger annotation
	@ApiOperation(value = "Add a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Education> createUser(@PathVariable("emailId") String emailId, @RequestBody Education user) {

		// TODO: add MISMATCH identifier validation exception

		return new ResponseEntity<>(this.educationService.createUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "update a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Education> createOrUpdateUser(@PathVariable("emailId") String emailId,
			@RequestBody Education user) {

		// TODO: add MISMATCH identifier validation exception

		return new ResponseEntity<>(this.educationService.createOrUpdateUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "delete a user")
	@RequestMapping(value = "/{emailId:.+}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Void> deleteUser(@PathVariable("emailId") String emailId) {

		this.educationService.deleteUser(emailId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
