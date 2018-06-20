package com.egiants.rlm.Exceptions;

public class MismatchIdentifierException extends RegistractionServiceException {

    private static final long serialVersionUID = 1L;
    private static final String ERROR_MESSAGE =
            "EmailId in header param %s doesn't matches with user request body";

    public MismatchIdentifierException(String emailId) {
        super(String.format(ERROR_MESSAGE, emailId));
    }

}
