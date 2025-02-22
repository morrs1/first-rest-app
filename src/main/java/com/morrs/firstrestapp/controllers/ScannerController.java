package com.morrs.firstrestapp.controllers;

import com.morrs.firstrestapp.dto.ScannerDTO;
import com.morrs.firstrestapp.exceptions.ScannerValidationException;
import com.morrs.firstrestapp.mappers.ScannerMapper;
import com.morrs.firstrestapp.models.Scanner;
import com.morrs.firstrestapp.services.ScannerService;
import com.morrs.firstrestapp.utils.ErrorResponse;
import com.morrs.firstrestapp.validators.ScannerValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/scanners")
public class ScannerController {

    private final ScannerMapper scannerMapper;
    private final ScannerService scannerService;
    private final ScannerValidator scannerValidator;

    @Autowired
    public ScannerController(ScannerMapper scannerMapper, ScannerService scannerService, ScannerValidator scannerValidator) {
        this.scannerMapper = scannerMapper;
        this.scannerService = scannerService;
        this.scannerValidator = scannerValidator;
    }

    @GetMapping()
    public List<ScannerDTO> readAll() {
        return scannerService.realAll().stream().map(this.scannerMapper::scannerToScannerDTO).toList();
    }

    @PostMapping("/registration")
    public ScannerDTO create(@RequestBody @Valid ScannerDTO scannerDTO, BindingResult bindingResult) {
        Scanner scanner = scannerMapper.scannerDTOToScanner(scannerDTO);
        scannerValidator.validate(scanner, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ScannerValidationException(
                    bindingResult.getAllErrors().stream().map(
                            DefaultMessageSourceResolvable::getDefaultMessage
                    ).collect(Collectors.joining())
            );
        }
        return scannerMapper.scannerToScannerDTO(scannerService.create(scanner));
    }

    @ExceptionHandler(ScannerValidationException.class)
    private ResponseEntity<ErrorResponse> handleException(ScannerValidationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage()));
    }

}
