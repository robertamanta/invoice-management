package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.InvoiceDetail;
import com.roberta.invoicemanagementbackend.repository.InvoiceDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;
    private final ProductServiceImpl productService;

    @Autowired
    public InvoiceDetailServiceImpl(InvoiceDetailRepository invoiceDetailRepository, ProductServiceImpl productService) {
        this.invoiceDetailRepository = invoiceDetailRepository;
        this.productService = productService;
    }

    @Override
    public List<InvoiceDetail> getAllDetailsForInvoice(Long invoiceId) {
        List<InvoiceDetail> details = invoiceDetailRepository.findAllDetailsForInvoice(invoiceId);
        if (details.isEmpty()) {
            throw new GlobalRequestException("No details found!");
        }
        return details;
    }

    @Override
    public InvoiceDetail getInvoiceDetailById(Long id) {
        Optional<InvoiceDetail> invoiceDetail = invoiceDetailRepository.findById(id);
        if (invoiceDetail.isEmpty()) {
            throw new GlobalRequestException("Detail with id: " + id + " not found!");
        }
        return invoiceDetail.get();
    }

    @Override
    public void create(InvoiceDetail invoiceDetail) {
        if (invoiceDetail.getId() != null) {
            Optional<InvoiceDetail> findInvoiceDetail = invoiceDetailRepository.findById(invoiceDetail.getId());
            if (findInvoiceDetail.isPresent()) {
                throw new GlobalRequestException("Detail with id: " + invoiceDetail.getId() + " already exists!");
            }
        }
        invoiceDetailRepository.save(invoiceDetail);
    }

    @Transactional
    public void update(Long id, InvoiceDetail invoiceDetail) {
        InvoiceDetail updateInvoiceDetail = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new GlobalRequestException("Invoice detail with number " + id + "not found!"));
        if (invoiceDetail.getQuantity() != 0.0f
                && !Objects.equals(updateInvoiceDetail.getQuantity(), invoiceDetail.getQuantity())) {
            updateInvoiceDetail.setQuantity(invoiceDetail.getQuantity());
        }
        if (invoiceDetail.getDiscountPercent() != 0.0f
                && !Objects.equals(updateInvoiceDetail.getDiscountPercent(), invoiceDetail.getDiscountPercent())) {
            updateInvoiceDetail.setDiscountPercent(invoiceDetail.getDiscountPercent());
        }

        if (invoiceDetail.getProduct() != null) {
            productService.update(updateInvoiceDetail.getProduct().getId(), invoiceDetail.getProduct());
        }


    }

    @Override
    public void delete(Long id) {
        boolean exists = invoiceDetailRepository.existsById(id);
        if (!exists) {
            throw new GlobalRequestException("Invoice detail with id: " + id + " does not exists!");
        }
        invoiceDetailRepository.deleteById(id);
    }
}
