package com.service.customer.service.impl;

import com.service.customer.model.entity.CustomerEntity;
import com.service.customer.model.response.CustomerResponse;
import com.service.customer.repository.CustomerRepository;
import com.service.customer.service.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public CustomerEntity findById(UUID id) {
        log.info("Get a Customer with ID: {}", id);
        return repository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + id));
    }

    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        log.info("Get all Customers");
        return repository.findAll(pageable);
    }

    @Override
    public CustomerEntity create(CustomerEntity entity) {
        log.info("Creating a new Customer with name equals: {}", entity.getName());
        return repository.save(entity);
    }

    @Override
    public CustomerEntity update(UUID id, String name, String email, LocalDate dateOfBirth, String cpfCnpj, String fone) {
        CustomerEntity entity = findById(id);

        if (!entity.getName().equals(name)) {
            entity.setName(name);
        }

        if (!entity.getEmail().equals(email)) {
            entity.setEmail(email);
        }

        if (!entity.getDateOfBirth().equals(dateOfBirth)) {
            entity.setDateOfBirth(dateOfBirth);
        }

        if (!entity.getCpfCnpj().equals(cpfCnpj)) {
            entity.setCpfCnpj(cpfCnpj);
        }

        if (!entity.getFone().equals(fone)) {
            entity.setFone(fone);
        }

        return repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting a Customer with id equals: {}", id);
        CustomerEntity entity = findById(id);
        entity.setDeleted(Boolean.TRUE);
        repository.save(entity);
    }

    @Override
    public CustomerEntity status(UUID id, boolean active) {
        log.info("Changing customer status with id: {}", id);
        CustomerEntity entity = findById(id);
        entity.setActive(active);
        return  repository.save(entity);
    }
}
