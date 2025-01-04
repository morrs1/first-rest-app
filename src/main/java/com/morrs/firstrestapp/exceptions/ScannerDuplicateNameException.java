package com.morrs.firstrestapp.exceptions;

public class ScannerDuplicateNameException extends RuntimeException {
    public ScannerDuplicateNameException(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
