package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.model.Invoice;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> getAll();

    public Invoice getInvoiceById(Long invoiceId);

    public void create(Invoice invoice);

    public void update(Long invoiceId, Invoice invoice);

    public void delete(Long invoiceId);


}
