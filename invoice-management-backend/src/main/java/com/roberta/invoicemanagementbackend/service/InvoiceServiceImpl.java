package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.Customer;
import com.roberta.invoicemanagementbackend.model.Invoice;
import com.roberta.invoicemanagementbackend.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        if(invoiceList.isEmpty()){
            throw new GlobalRequestException("Invoices not found!");
        }
        return invoiceList;
    }

    @Override
    public Invoice getInvoiceById(Long invoiceId) {
        Optional<Invoice> findInvoice = invoiceRepository.findById(invoiceId);
        if (findInvoice.isEmpty()) {
            throw new GlobalRequestException("Invoice not found!");
        }
        return findInvoice.get();
    }

    @Override
    public void create(Invoice invoice) {
        if (invoice.getInvoiceNumber()!=null) {
            Optional<Invoice> findInvoice = invoiceRepository.findById(invoice.getInvoiceNumber());
            if (findInvoice.isPresent()) {
                throw new GlobalRequestException("Invoice with number: " + invoice.getInvoiceNumber() + " already exists!");
            }
        }
        invoiceRepository.save(invoice);
    }

    @Transactional
    public void update(Long invoiceId, Invoice invoice) {
            Invoice updateInvoice =  invoiceRepository.findById(invoiceId)
                    .orElseThrow(() ->new GlobalRequestException("Invoice with number " + invoiceId + "not found!"));
        if (invoice.getStatus() != null
                && !Objects.equals(updateInvoice.getStatus(), invoice.getStatus())) {
            updateInvoice.setStatus(invoice.getStatus());
        }
        if (invoice.getDueDate() != null
                && !Objects.equals(updateInvoice.getDueDate(), invoice.getDueDate())) {
            updateInvoice.setDueDate(invoice.getDueDate());
        }
        if (invoice.getDueDate() != null
                && !Objects.equals(updateInvoice.getDueDate(), invoice.getDueDate())) {
            updateInvoice.setDueDate(invoice.getDueDate());
        }
        if (invoice.getDetails() != null
                && !Objects.equals(updateInvoice.getDetails(), invoice.getDetails())) {
            updateInvoice.setDetails(invoice.getDetails());
        }
        if (invoice.getCustomer() != null
                && !Objects.equals(updateInvoice.getCustomer(), invoice.getCustomer())) {
            updateInvoice.setCustomer(invoice.getCustomer());
        }
        if (invoice.getShippingInfo() != null
                && !Objects.equals(updateInvoice.getShippingInfo(), invoice.getShippingInfo())) {
            updateInvoice.setShippingInfo(invoice.getShippingInfo());
        }
        if (invoice.getTotalAmount() != null
                && !Objects.equals(updateInvoice.getTotalAmount(), invoice.getTotalAmount())) {
            updateInvoice.setTotalAmount(invoice.getTotalAmount());
        }


    }

    @Override
    public void delete(Long invoiceId) {
       boolean exists = invoiceRepository.existsById(invoiceId);
       if(!exists)
       {
           throw new GlobalRequestException("Invoice with id: " + invoiceId + " does not exists!");
       }
       invoiceRepository.deleteById(invoiceId);
    }
}
