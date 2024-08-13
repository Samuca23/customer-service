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
        log.info("Create a new Customer with name equals: {}", entity.getName());
        return repository.save(entity);
    }

    @Override
    public CustomerEntity update(CustomerEntity entity) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
