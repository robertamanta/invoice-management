package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAll();

    public Customer getCustomerById(Long customerId);

    public Customer getCustomerByEmail(String email);

    public void create(Customer customer);

    public void update(Long customerId, Customer customer);

    public void delete(Long customerId);


}
