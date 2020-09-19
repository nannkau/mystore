package com.team.mystore.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "categoryId" )
    private int categoryId;

    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "flagDelete", nullable = false)
    private String flagDelete;

    @OneToMany(mappedBy="category", cascade=CascadeType.ALL)
    List<Product> products;


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

