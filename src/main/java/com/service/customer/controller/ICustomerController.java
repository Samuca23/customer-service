package com.service.customer.controller;

import com.service.customer.model.entity.CustomerEntity;
import com.service.customer.model.request.CustomerRequest;
import com.service.customer.model.response.CustomerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Management System")
public interface ICustomerController {

    @ApiOperation(value = "Get a customer by Id")
    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> findById(@PathVariable UUID id);

    @ApiOperation(value = "Get all customer's")
    @GetMapping
    ResponseEntity<Page<CustomerResponse>> findAll(Pageable pageable);

    @ApiOperation(value = "Create a customer")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request);

    @ApiOperation(value = "Update a customer")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerResponse> update(@RequestBody CustomerRequest request,
                                            @PathVariable UUID id);

    @ApiOperation(value = "Delete a customer")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerResponse> delete(@PathVariable UUID id);

}
