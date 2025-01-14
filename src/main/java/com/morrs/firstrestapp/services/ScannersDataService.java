package com.morrs.firstrestapp.services;

import com.morrs.firstrestapp.models.ScannersData;
import com.morrs.firstrestapp.repos.ScannersDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ScannersDataService {

    private final ScannersDataRepo scannersDataRepo;

    @Autowired
    public ScannersDataService(ScannersDataRepo scannersDataRepo) {
        this.scannersDataRepo = scannersDataRepo;
    }

    public List<ScannersData> readAll() {
        return scannersDataRepo.findAll();
    }


}
