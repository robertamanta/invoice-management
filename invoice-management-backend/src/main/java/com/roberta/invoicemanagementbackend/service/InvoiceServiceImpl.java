package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.model.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Override
    public List<Invoice> getAll() {
        return null;
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        return null;
    }

    @Override
    public void create(Invoice invoice) {

    }

    @Override
    public void update(Long invoiceId, Invoice invoice) {

    }

    @Override
    public void delete(Long invoiceId) {

    }
}
