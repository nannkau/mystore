package com.team.mystore.dto;

import com.team.mystore.entity.Category;
import com.team.mystore.entity.Supplier;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto {
    private Integer productId;
    @NotEmpty(message = "Name is required")
    @Size(min = 3,max = 100)
    private String name;
    @NotEmpty(message = "Amount total number is required")
    @Pattern(regexp = "-?[1-9]\\d*|0",message = "Amount total number is invalid")
    private Integer amountTotal;
    @NotEmpty(message = "Price number is required")
    @Pattern(regexp = "-?[1-9]\\d*|0",message = "Price number is invalid")
    private Integer price;
    @NotEmpty(message = "detail is required")
    @Size(min = 10,max = 200)
    private String detail;
    @NotEmpty(message = "Status is required")
    @Size(min = 1,max = 1)
    private String status;
    @NotEmpty(message = "Supplier is required")
    private Supplier supplier;
    @NotEmpty(message = "Category is required")
    private Category category;
    private String image;
    private MultipartFile part;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public MultipartFile getPart() {
        return part;
    }

    public void setPart(MultipartFile part) {
        this.part = part;
    }
}
