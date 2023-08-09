package com.roberta.invoicemanagementbackend.controller;

;
import com.roberta.invoicemanagementbackend.model.Invoice;
import com.roberta.invoicemanagementbackend.service.InvoiceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-management/invoices")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    @Autowired
    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "{id}")
    public Invoice getInvoice(@PathVariable("id") Long id )
    {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping()
    public List<Invoice> getAllInvoices( )
    {
        return invoiceService.getAll();
    }

    @PostMapping
    public void createInvoice(@Valid @RequestBody Invoice invoice){
        invoiceService.create(invoice);
    }

    @PutMapping(path = "{id}")
    public void updateInvoice(@PathVariable("id") Long id,@Valid @RequestBody Invoice invoice){
        invoiceService.update(id,invoice);
    }

    @DeleteMapping(path = "{id}")
    public void deleteInvoice(@PathVariable("id") Long id )
    {
        invoiceService.delete(id);

    }
}
