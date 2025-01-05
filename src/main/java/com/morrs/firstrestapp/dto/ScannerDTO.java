package com.morrs.firstrestapp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScannerDTO(@NotNull(message = "Name must be not empty")
                         @Size(min = 3, max = 30, message = "Length must me more than 3 and less then 30") String name) {
}
