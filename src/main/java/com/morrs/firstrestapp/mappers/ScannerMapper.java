package com.morrs.firstrestapp.mappers;

import com.morrs.firstrestapp.dto.ScannerDTO;
import com.morrs.firstrestapp.models.Scanner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScannerMapper {

    ScannerDTO scannerToScannerDTO(Scanner scanner);

    Scanner scannerDTOToScanner(ScannerDTO scannerDTO);

}
