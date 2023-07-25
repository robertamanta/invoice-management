package com.roberta.invoicemanagementbackend.controller;

import com.roberta.invoicemanagementbackend.model.Customer;
import com.roberta.invoicemanagementbackend.service.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/invoice_management/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {

        this.customerService = customerService;
    }

    @PostMapping()
    public void saveCustomer(@Valid @RequestBody Customer customer) {
        customerService.create(customer);
    }

    @GetMapping()
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody Customer customer
    ) {
        customerService.update(id, customer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
    }


}


