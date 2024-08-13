package com.service.customer.service;

import com.service.customer.model.entity.CustomerEntity;
import com.service.customer.model.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICustomerService {

    CustomerEntity findById(UUID id);

    Page<CustomerEntity> findAll(Pageable pageable);

    CustomerEntity create(CustomerEntity entity);

    CustomerEntity update(CustomerEntity entity);

    void delete(UUID id);

}
