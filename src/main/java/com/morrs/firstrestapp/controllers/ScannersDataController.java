package com.morrs.firstrestapp.controllers;

import com.morrs.firstrestapp.dto.ScannersDataDTO;
import com.morrs.firstrestapp.exceptions.ScannersDataValidationException;
import com.morrs.firstrestapp.mappers.ScannersDataMapper;
import com.morrs.firstrestapp.models.ScannersData;
import com.morrs.firstrestapp.services.ScannerService;
import com.morrs.firstrestapp.services.ScannersDataService;
import com.morrs.firstrestapp.utils.ErrorResponse;
import com.morrs.firstrestapp.validators.ScannersDataValidator;
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
@RequestMapping("/api/scanners_data")
public class ScannersDataController {

    private final ScannersDataService scannersDataService;
    private final ScannersDataMapper scannersDataMapper;
    private final ScannerService scannersService;
    private final ScannersDataValidator scannersDataValidator;

    @Autowired
    public ScannersDataController(ScannersDataService scannersDataService, ScannersDataMapper scannersDataMapper, ScannerService scannersService, ScannersDataValidator scannersDataValidator) {
        this.scannersDataService = scannersDataService;
        this.scannersDataMapper = scannersDataMapper;
        this.scannersService = scannersService;
        this.scannersDataValidator = scannersDataValidator;
    }

    @GetMapping()
    public List<ScannersDataDTO> readAll() {
        scannersDataService.readAll().forEach(System.out::println);
        return scannersDataService.readAll().stream().map(
                scannersDataMapper::scannersDataToScannersDataDTO
        ).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ScannersDataDTO add(@RequestBody @Valid ScannersDataDTO scannersDataDTO, BindingResult bindingResult) {
        ScannersData newScannersData = scannersDataMapper.scannersDataDTOToScannersData(scannersDataDTO);

        scannersDataValidator.validate(newScannersData, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ScannersDataValidationException(
                    bindingResult.getAllErrors().stream().map(
                            DefaultMessageSourceResolvable::getDefaultMessage
                    ).collect(Collectors.joining()));
        }

        newScannersData.getScanner().setId(scannersService.readByName(scannersDataDTO.scannerDTO().name()).getId());
        return scannersDataMapper.scannersDataToScannersDataDTO(scannersDataService.create(newScannersData));
    }

    @GetMapping("/rainy_days_count")
    public String getRainyDaysCount() {
       return Integer.toString(scannersDataService.getRainyDaysCount());
    }


    @ExceptionHandler(ScannersDataValidationException.class)
    private ResponseEntity<ErrorResponse> handleException(ScannersDataValidationException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }
}
