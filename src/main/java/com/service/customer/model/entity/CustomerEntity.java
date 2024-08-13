package com.service.customer.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "cpf_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(nullable = false, length = 20)
    private String fone;

}
