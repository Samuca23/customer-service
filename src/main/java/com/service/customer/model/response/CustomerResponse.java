package com.service.customer.model.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponse(UUID id,
                               String name,
                               LocalDate dateOfBirth,
                               String cpfCnpj,
                               String fone,
                               LocalDateTime createAt,
                               LocalDateTime updateAt,
                               String createBy,
                               String updateBy) {
}
