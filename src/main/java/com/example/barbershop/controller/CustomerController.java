package com.example.barbershop.controller;

import com.example.barbershop.service.ICustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Arrays;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.barbershop.model.Customer;
import com.example.barbershop.dto.GenericResponse;
@RestController 
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService service;

    @GetMapping
    public ResponseEntity<GenericResponse<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<Customer>> findById(@PathVariable Integer id) {
        Customer obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "Success", Arrays.asList((obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Customer customer) {
        Customer obj = service.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCustomer()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<Customer>> update(@Valid @RequestBody Customer customer, @PathVariable Integer id) {
        customer.setIdCustomer(id);
        Customer obj = service.update(id, customer);
        return ResponseEntity.ok(new GenericResponse<>(200, "Customer updated successfully", Arrays.asList(obj)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
