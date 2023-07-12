package com.roberta.invoicemanagementbackend.model;

import com.roberta.invoicemanagementbackend.enumeration.Status;
import com.roberta.invoicemanagementbackend.enumeration.Type;

import java.time.LocalDate;

public class Invoice {

    private Long id;
    private String invoiceNumber;
    private Type type;
    private Status status;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private String Details;
    private Customer customer;
    private ShippingInfo shippingInfo;
    private InvoiceDetail invoiceDetail;
    private Integer totalAmount;





}
