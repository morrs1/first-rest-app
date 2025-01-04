package com.morrs.firstrestapp.validators;

import com.morrs.firstrestapp.models.Scanner;
import com.morrs.firstrestapp.repos.ScannersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ScannerValidator implements Validator {

    private final ScannersRepo scannersRepo;

    @Autowired
    public ScannerValidator(ScannersRepo scannersRepo) {
        this.scannersRepo = scannersRepo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Scanner.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Scanner scanner = (Scanner) target;
        if (scannersRepo.existsByName(scanner.getName())){
          errors.rejectValue("name", "duplicate", "This name is already in use");
        };

    }
}
