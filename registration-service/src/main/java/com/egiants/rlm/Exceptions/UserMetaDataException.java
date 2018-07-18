package com.egiants.rlm.Exceptions;

public class UserMetaDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String ERROR_MESSAGE =
			"No Registration was done by admin with  %s. Please contact admin for more information";

	public UserMetaDataException(String emailId) {
		super(String.format(ERROR_MESSAGE, emailId));
	}

}
