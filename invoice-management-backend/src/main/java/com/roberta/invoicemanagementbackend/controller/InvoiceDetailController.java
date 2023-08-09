package com.roberta.invoicemanagementbackend.controller;

import com.roberta.invoicemanagementbackend.model.InvoiceDetail;
import com.roberta.invoicemanagementbackend.service.InvoiceDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-management/invoice-details")
public class InvoiceDetailController {

    private final InvoiceDetailServiceImpl invoiceDetailService;

    @Autowired
    public InvoiceDetailController(InvoiceDetailServiceImpl invoiceDetailService) {
        this.invoiceDetailService = invoiceDetailService;
    }


    @GetMapping(path = "{id}")
    public InvoiceDetail getInvoiceDetail(@PathVariable("id") Long id) {
        return invoiceDetailService.getInvoiceDetailById(id);
    }

    @GetMapping()
    public List<InvoiceDetail> getAllInvoiceDetails(@RequestParam(value = "invoiceNr") Long invoiceId) {
        return invoiceDetailService.getAllDetailsForInvoice(invoiceId);
    }

    @PostMapping
    public void createInvoiceDetail(@Valid @RequestBody InvoiceDetail invoiceDetail) {
        invoiceDetailService.create(invoiceDetail);
    }

    @PutMapping(path = "{id}")
    public void updateInvoiceDetail(@PathVariable("id") Long id, @Valid @RequestBody InvoiceDetail invoiceDetail) {
        invoiceDetailService.update(id, invoiceDetail);
    }

    @DeleteMapping(path = "{id}")
    public void deleteInvoiceDetail(@PathVariable("id") Long id) {
        invoiceDetailService.delete(id);

    }
}
