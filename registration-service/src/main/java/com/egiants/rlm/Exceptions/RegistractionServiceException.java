package com.egiants.rlm.Exceptions;

public class RegistractionServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE = "User information with %s doesn't exists";

	public RegistractionServiceException(String emailId) {
		super(String.format(ERROR_MESSAGE, emailId));
	}

}
