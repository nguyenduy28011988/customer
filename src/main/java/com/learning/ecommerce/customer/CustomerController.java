package com.learning.ecommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @GetMapping("/exits/{customer-id}")
    public  ResponseEntity<Boolean> existById(
            @PathVariable("customer-id") String customerid) {


        return ResponseEntity.ok(service.existById(customerid));
    }

    @GetMapping("/{customer-id}")
    public  ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerid) {
        return ResponseEntity.ok(service.findById(customerid));
    }

    @DeleteMapping("/{customer-id}")
    public  ResponseEntity<CustomerResponse> delete(
            @PathVariable("customer-id") String customerid) {
        service.deleteCustomer(customerid);
        return ResponseEntity.accepted().build();
    }
}
