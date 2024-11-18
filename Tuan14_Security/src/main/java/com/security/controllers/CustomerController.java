package com.security.controllers;

import com.security.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity

public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder().id("001")
                    .name("Vo Van Tuan")
                    .email("123@gmail.com").build(),
            Customer.builder().id("001")
                    .name("Vo Tuan")
                    .email("123@gmail.com").build());

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello is Guest");
    }

    @GetMapping("/customer/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = this.customers;
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }

}
