package com.team.mystore.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "code")
    private String code;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "amount_total")
    private Integer amountTotal;
    @Column(name = "price")
    private Integer price;
    @Column(name = "sale_price")
    private Integer salePrice;
    @Column(name = "image",length = 100)
    private String image;
    @Column(name = "sex" ,length = 1)
    private String sex;
    @Column(name = "sizeProduct" ,length=2)
    private String sizeProduct;
    @Column(name = "detail",length = 100)
    private String detail;
    @Column(name = "status", nullable = false,length = 1)
    private String status;
    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> invoiceDetails=new ArrayList<>();
    @OneToMany(mappedBy = "product")
    private List<RecevieDetail> recevieDetails= new ArrayList<>();

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name may not be empty") String name) {
        this.name = name;
    }

    public Integer getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public List<RecevieDetail> getRecevieDetails() {
        return recevieDetails;
    }

    public void setRecevieDetails(List<RecevieDetail> recevieDetails) {
        this.recevieDetails = recevieDetails;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(String sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

