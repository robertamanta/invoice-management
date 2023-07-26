package com.roberta.invoicemanagementbackend.service;

import com.roberta.invoicemanagementbackend.exception.GlobalRequestException;
import com.roberta.invoicemanagementbackend.model.Address;
import com.roberta.invoicemanagementbackend.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void update(Long addressId, Address address) {
        Address updateAddress = addressRepository.findById(addressId)
                .orElseThrow(() -> new GlobalRequestException("Address with id!" + addressId + " does not exists!"));

        if (address.getCity() != null
                && address.getCity().length() > 0
                && !Objects.equals(address.getCity(), updateAddress.getCity())
        ) {
            updateAddress.setCity(address.getCity());
        }

        if (address.getCountry() != null
                && address.getCountry().length() > 0
                && !Objects.equals(address.getCountry(), updateAddress.getCountry())
        ) {
            updateAddress.setCountry(address.getCountry());
        }

        if (address.getNumber() != null
                && address.getNumber().length() > 0
                && !Objects.equals(address.getNumber(), updateAddress.getNumber())
        ) {
            updateAddress.setNumber(address.getNumber());
        }

        if (address.getStreet() != null
                && address.getStreet().length() > 0
                && !Objects.equals(address.getStreet(), updateAddress.getStreet())
        ) {
            updateAddress.setStreet(address.getStreet());
        }

        if (address.getPostCode() != null
                && address.getPostCode().length() > 0
                && !Objects.equals(address.getPostCode(), updateAddress.getPostCode())
        ) {
            updateAddress.setPostCode(address.getPostCode());
        }
    }
}
