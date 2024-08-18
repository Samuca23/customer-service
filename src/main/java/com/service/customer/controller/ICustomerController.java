package com.service.customer.controller;

import com.service.customer.model.request.CustomerRequest;
import com.service.customer.model.request.CustomerStatusRequest;
import com.service.customer.model.response.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer", description = "Customer Service")
public interface ICustomerController {

    @Operation(summary = "Get by ID", description = "Get a customer by Id")
    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> findById(@PathVariable UUID id);

    @Operation(summary = "Get all", description = "Get all customer's")
    @GetMapping
    ResponseEntity<Page<CustomerResponse>> findAll(@Parameter(hidden = true) Pageable pageable);

    @Operation(summary = "Create", description = "Create a customer")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request);

    @Operation(summary = "Update", description = "Update a customer")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerResponse> update(@RequestBody CustomerRequest request,
                                            @PathVariable UUID id);

    @Operation(summary = "Delete", description = "Delete a customer")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable UUID id);

    @Operation(summary = "Status", description = "Update status")
    @PutMapping("/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerResponse> status(@RequestBody CustomerStatusRequest request,
                                            @PathVariable UUID id);

}
