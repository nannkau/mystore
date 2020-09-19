package com.team.mystore.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoiceDetail")
public class InvoiceDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceDetailId")
    private Integer InvoiceDetailId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    public Integer getInvoiceDetailId() {
        return InvoiceDetailId;
    }

    public void setInvoiceDetailId(Integer invoiceDetailId) {
        InvoiceDetailId = invoiceDetailId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
