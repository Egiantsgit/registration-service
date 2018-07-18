package com.egiants.rlm.Exceptions;

public class ResourceNotFoundException extends RegistractionServiceException {

    public ResourceNotFoundException(String emailId) {
        super(emailId);
    }
}
