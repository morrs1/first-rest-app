package com.morrs.firstrestapp.controllers;

import com.morrs.firstrestapp.models.Scanner;
import com.morrs.firstrestapp.services.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/scanner")
public class ScannerController {


    private final ScannerService scannerService;

    @Autowired
    public ScannerController(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @GetMapping()
    public List<Scanner> readAll() {
        return scannerService.realAll();
    }

}
