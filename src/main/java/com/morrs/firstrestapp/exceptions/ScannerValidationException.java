package com.morrs.firstrestapp.exceptions;

public class ScannerValidationException extends RuntimeException {
    public ScannerValidationException(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
