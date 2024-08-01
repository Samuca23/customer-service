package com.service.customer.model.response;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse(UUID id,
                               String name,
                               LocalDate dateOfBirth,
                               String cpfCnpj,
                               String fone) {
}
