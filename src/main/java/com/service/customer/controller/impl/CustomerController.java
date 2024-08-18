package com.service.customer.controller.impl;

import com.service.customer.controller.ICustomerController;
import com.service.customer.model.entity.CustomerEntity;
import com.service.customer.model.request.CustomerRequest;
import com.service.customer.model.request.CustomerStatusRequest;
import com.service.customer.model.response.CustomerResponse;
import com.service.customer.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerController implements ICustomerController {

    @Autowired
    CustomerService service;

    @Override
    public ResponseEntity<CustomerResponse> findById(UUID id) {
        return ResponseEntity.ok(CustomerResponse.parse(service.findById(id)));
    }

    @Override
    public ResponseEntity<Page<CustomerResponse>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(CustomerResponse::parse));
    }

    @Override
    public ResponseEntity<CustomerResponse> create(CustomerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse.parse(service.create(CustomerRequest.parse(request))));
    }

    @Override
    public ResponseEntity<CustomerResponse> update(CustomerRequest request, UUID id) {
        return ResponseEntity.ok(CustomerResponse.parse(service.update(id, request.name(), request.email(), request.dateOfBirth(), request.cpfCnpj(), request.fone())));
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public ResponseEntity<CustomerResponse> status(CustomerStatusRequest request, UUID id) {
        return ResponseEntity.ok(CustomerResponse.parse(service.status(id, request.active())));
    }
}
