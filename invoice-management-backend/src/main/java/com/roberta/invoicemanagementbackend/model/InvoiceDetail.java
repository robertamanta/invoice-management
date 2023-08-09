package com.roberta.invoicemanagementbackend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice_details")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    @Valid
    private Product product;

    @NotNull(message = "Please insert the quantity!")
    private float quantity;

    private float discountPercent;

    @Formula("(SELECT round(COALESCE(a.quantity,0)*COALESCE(b.price,0),2) FROM invoice_details a INNER JOIN products b ON a.product_id=b.id where a.id=id)")
    private BigDecimal total;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    @Valid
    private Invoice invoice;

    public InvoiceDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


}
