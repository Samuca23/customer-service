package com.service.customer.controller.impl;

import com.service.customer.controller.ICustomerController;
import com.service.customer.model.request.CustomerRequest;
import com.service.customer.model.response.CustomerResponse;
import com.service.customer.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerController implements ICustomerController {

    @Autowired
    CustomerService service;

    @Override
    public ResponseEntity<CustomerResponse> findById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<CustomerResponse>> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerResponse> create(CustomerRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerResponse> update(CustomerRequest request, UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerResponse> delete(UUID id) {
        return null;
    }
}
