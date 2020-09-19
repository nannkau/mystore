package com.team.mystore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId")
    private  Integer supplierId;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "phoneNumber",length = 15)
    private String phoneNumber;
    @Column(name = "address",length = 100)
    private String address;
    @Column(name = "flagDelete", nullable = false)
    private String flagDelete;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products= new ArrayList<>();

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(String flagDelete) {
        this.flagDelete = flagDelete;
    }
}
