package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product getProductById(Long customerId);

    public void create(Product product);

    public void update(Long productId, Product product);

    public void delete(Long productId);
}
