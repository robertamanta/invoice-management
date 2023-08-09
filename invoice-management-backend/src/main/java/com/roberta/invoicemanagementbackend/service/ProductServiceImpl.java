package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.Product;
import com.roberta.invoicemanagementbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getProductById(Long customerId) {
        return null;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Long productId, Product product) {

        Product updateProduct = productRepository.findById(productId)
                .orElseThrow(() -> new GlobalRequestException("Product with id " + productId + "not found!"));

        if (product.getName() != null && !Objects.equals(updateProduct.getName(), product.getName())) {
            updateProduct.setName(product.getName());
        }
        if (product.getDescription() != null && !Objects.equals(updateProduct.getDescription(), product.getDescription())) {
            updateProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != null && !Objects.equals(updateProduct.getPrice(), product.getPrice())) {
            updateProduct.setPrice(product.getPrice());
        }
        if (!Objects.equals(updateProduct.getVat(), product.getVat())) {
            updateProduct.setVat(product.getVat());
        }
        if (product.getCurrency() != null && !Objects.equals(updateProduct.getCurrency(), product.getCurrency())) {
            updateProduct.setCurrency(product.getCurrency());
        }


    }

    @Override
    public void delete(Long productId) {


    }

}
