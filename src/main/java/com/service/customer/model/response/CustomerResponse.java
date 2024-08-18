package com.service.customer.model.response;

import com.service.customer.model.entity.CustomerEntity;
import com.service.customer.model.request.CustomerRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponse(UUID id,
                               String name,
                               String email,
                               LocalDate dateOfBirth,
                               String cpfCnpj,
                               String fone,
                               boolean active,
                               LocalDateTime createAt,
                               LocalDateTime updateAt,
                               boolean deleted) {

    public static CustomerResponse parse (CustomerEntity entity) {
        return new CustomerResponse(entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDateOfBirth(),
                entity.getCpfCnpj(),
                entity.getFone(),
                entity.isActive(),
                entity.getCreateAt(),
                entity.getUpdateAt(),
                entity.isDeleted());
    }

}
