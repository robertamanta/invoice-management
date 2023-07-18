package com.roberta.invoicemanagementbackend.service;


import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.Address;
import com.roberta.invoicemanagementbackend.model.Customer;
import com.roberta.invoicemanagementbackend.repository.AddressRepository;
import com.roberta.invoicemanagementbackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;


    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;

        this.addressRepository = addressRepository;
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


    @Transactional
    public void update(Long customerId, Customer customer) {
        Customer updateCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new GlobalRequestException("Customer with id!" + customerId + " does not exists!"));
        if (customer.getName() != null
                && customer.getName().length() > 0
                && !Objects.equals(updateCustomer.getName(), customer.getName())) {
            updateCustomer.setName(customer.getName());
        }
        if (customer.getEmail() != null
                && customer.getEmail().length() > 0
                && !Objects.equals(updateCustomer.getEmail(), customer.getEmail())) {
            updateCustomer.setEmail(customer.getEmail());
        }
        if (customer.getPhoneNumber() != null
                && customer.getPhoneNumber().length() > 0
                && !Objects.equals(updateCustomer.getPhoneNumber(), customer.getPhoneNumber())
        ) {
            updateCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
        if (customer.getAddress() != null) {
            Address updateAddress = addressRepository.findById(updateCustomer.getAddress().getAddressId()).get();
            updateAddress.setCity(customer.getAddress().getCity());
            updateAddress.setCountry(customer.getAddress().getCountry());
            updateAddress.setNumber(customer.getAddress().getNumber());
            updateAddress.setStreet(customer.getAddress().getStreet());
            updateAddress.setPostCode(customer.getAddress().getPostCode());
        }

    }

    @Override
    public void delete(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new GlobalRequestException("Customer with id: " + customerId + " does not exists!");
        }
        customerRepository.deleteById(customerId);
    }
}