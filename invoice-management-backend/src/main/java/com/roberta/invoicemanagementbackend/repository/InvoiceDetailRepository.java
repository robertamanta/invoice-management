package com.roberta.invoicemanagementbackend.repository;

import com.roberta.invoicemanagementbackend.model.Customer;
import com.roberta.invoicemanagementbackend.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {

    @Query("SELECT d from InvoiceDetail d where d.invoice.invoiceNumber=?1")
    List<InvoiceDetail> findAllDetailsForInvoice(Long invoiceId);


}
