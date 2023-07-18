package com.roberta.invoicemanagementbackend.repository;

import com.roberta.invoicemanagementbackend.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {
}
