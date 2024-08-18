package com.service.customer.model.request;

import com.service.customer.model.entity.CustomerEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;


public record CustomerRequest(UUID id,
                              @NotBlank @Max(255) String name,
                              @NotBlank @Max(255) String email,
                              @NotNull LocalDate dateOfBirth,
                              @NotBlank String cpfCnpj,
                              @NotBlank String fone,
                              @NotNull boolean active) {

    public static CustomerEntity parse(CustomerRequest request) {
        return CustomerEntity.builder()
                .id(request.id())
                .name(request.name())
                .email(request.email())
                .dateOfBirth(request.dateOfBirth())
                .cpfCnpj(request.cpfCnpj())
                .fone(request.fone())
                .active(request.active())
                .build();
    }

}
