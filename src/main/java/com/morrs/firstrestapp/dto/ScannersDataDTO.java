package com.morrs.firstrestapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ScannersDataDTO(
        @Min(value= -100, message = "Value must be greater then -100")
        @Max(value = 100, message ="Value must be less then 100")
        @NotNull(message = "Value must ne not empty")
        int value,

        @NotNull(message = "Value must ne not empty")
        boolean raining,

        @NotNull(message = "Value must ne not empty")
        ScannerDTO scannerDTO
) {
}
