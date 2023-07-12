package com.roberta.invoicemanagementbackend.service;


import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.Customer;
import com.roberta.invoicemanagementbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> findCustomer = customerRepository.findById(customerId);
        if (findCustomer.isEmpty()) {
            throw new GlobalRequestException("Customer not found!");
        }
        return findCustomer.get();
    }

    @Override
    public void create(Customer customer) {
        Optional<Customer> findCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if (findCustomer.isPresent()) {
            throw new GlobalRequestException("Customer already exists!");
        }
        customerRepository.save(customer);
    }

    @Override
    public void update(Long customerId) {

    }

    @Override
    public void delete(Long customerId) {

    }
}