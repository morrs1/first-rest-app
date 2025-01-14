package com.morrs.firstrestapp.controllers;

import com.morrs.firstrestapp.dto.ScannersDataDTO;
import com.morrs.firstrestapp.mappers.ScannersDataMapper;
import com.morrs.firstrestapp.services.ScannersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scanners_data")
public class ScannersDataController {

    private final ScannersDataService scannersDataService;
    private final ScannersDataMapper scannersDataMapper;

    @Autowired
    public ScannersDataController(ScannersDataService scannersDataService, ScannersDataMapper scannersDataMapper) {
        this.scannersDataService = scannersDataService;
        this.scannersDataMapper = scannersDataMapper;
    }

    @GetMapping()
    public List<ScannersDataDTO> readAll() {
        scannersDataService.readAll().forEach(System.out::println);
        return scannersDataService.readAll().stream().map(scannersDataMapper::scannersDataToScannersDataDTO).collect(Collectors.toList());
    }
}
