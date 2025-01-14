package com.morrs.firstrestapp.mappers;

import com.morrs.firstrestapp.dto.ScannersDataDTO;
import com.morrs.firstrestapp.models.ScannersData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScannersDataMapper {
    @Mapping(source = "scanner", target = "scannerDTO")
    ScannersDataDTO scannersDataToScannersDataDTO(ScannersData scannersData);

    ScannersData scannersDataDTOToScannersData(ScannersDataDTO scannersDataDTO);
}
