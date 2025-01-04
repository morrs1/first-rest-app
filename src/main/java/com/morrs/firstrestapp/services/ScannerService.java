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
        return scannersRepo.findAll();
    }

    @Transactional()
    public Scanner create(Scanner scanner) {
        System.out.println(scanner);
        return scannersRepo.save(scanner);
    }
}
