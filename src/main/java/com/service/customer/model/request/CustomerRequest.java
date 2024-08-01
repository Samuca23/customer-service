package com.service.customer.model.request;

import com.service.customer.model.entity.CustomerEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerRequest(
        UUID id,
        @NotBlank @Size(max = 255) String name,
        @NotNull LocalDate dateOfBirth,
        @NotBlank String cpfCnpj,
        @NotBlank String fone) {

}
