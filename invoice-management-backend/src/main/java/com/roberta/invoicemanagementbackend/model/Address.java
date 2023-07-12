package com.roberta.invoicemanagementbackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long addressId;

    @NotNull(message = "Number required!")
    private String number;

    @NotBlank(message = "Street required!")
    private String street;

    @NotBlank(message = "City required!")
    private String city;

    private String postCode;

    @NotBlank(message = "Country required!")
    private String country;

    @JsonBackReference
    @OneToOne(mappedBy =  "address")
    private Customer customer;


    public Address() {
    }

    public Address(Long addressId, String number, String street, String city, String postCode, String country) {
        this.addressId = addressId;
        this.number = number;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
