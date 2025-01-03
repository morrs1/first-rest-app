package com.morrs.firstrestapp.services;

import com.morrs.firstrestapp.models.Scanner;
import com.morrs.firstrestapp.repos.ScannersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ScannerService {
    private final ScannersRepo scannersRepo;

    @Autowired
    public ScannerService(ScannersRepo scannersRepo) {
        this.scannersRepo = scannersRepo;
    }

    public List<Scanner> realAll() {
        System.out.println(scannersRepo.findAll());
        return scannersRepo.findAll();
    }
}
