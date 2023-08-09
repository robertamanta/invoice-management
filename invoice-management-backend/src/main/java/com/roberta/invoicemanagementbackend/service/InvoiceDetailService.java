package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.model.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {

    public List<InvoiceDetail> getAllDetailsForInvoice(Long invoiceId);

    public InvoiceDetail getInvoiceDetailById(Long id);

    public void create(InvoiceDetail invoiceDetail);

    public void update(Long id, InvoiceDetail invoiceDetail);

    public void delete(Long id);
}
