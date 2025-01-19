package com.morrs.firstrestapp.validators;

import com.morrs.firstrestapp.models.ScannersData;
import com.morrs.firstrestapp.repos.ScannersDataRepo;
import com.morrs.firstrestapp.repos.ScannersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ScannersDataValidator implements Validator {

    private final ScannersDataRepo scannersDataRepo;
    private final ScannersRepo scannersRepo;

    @Autowired
    public ScannersDataValidator(ScannersDataRepo scannersDataRepo, ScannersRepo scannersRepo) {
        this.scannersDataRepo = scannersDataRepo;
        this.scannersRepo = scannersRepo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ScannersData.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ScannersData scannersData = (ScannersData) target;
        if (!scannersRepo.existsByName(scannersData.getScanner().getName())) {
            errors.rejectValue("scannerDTO","notFound", "There is no scanner with this name.");
        }
    }
}
