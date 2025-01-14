package com.morrs.firstrestapp.exceptions;

public class ScannersDataValidationException extends RuntimeException {
    public ScannersDataValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
