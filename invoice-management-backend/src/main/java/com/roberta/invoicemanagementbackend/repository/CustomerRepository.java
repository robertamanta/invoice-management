package com.roberta.invoicemanagementbackend.repository;


import com.roberta.invoicemanagementbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c from Customer c where c.email=?1")
    Optional<Customer> findCustomerByEmail(String email);


}


