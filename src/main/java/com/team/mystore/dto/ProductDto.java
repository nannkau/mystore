package com.team.mystore.dto;

import com.team.mystore.entity.Category;
import com.team.mystore.entity.Supplier;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

public class ProductDto {
    private Integer productId;
    @NotEmpty(message = "Name is required")
    @Size(min = 3,max = 100)
    private String name;
    @NotEmpty(message = "Name is required")
    @Size(min = 3,max = 100)
    private String code;
    @NotNull(message = "Amount total number is required")
    @Min(value = 1, message = "The value must be positive")
    private Integer amountTotal;
    @NotNull(message = "Price number is required")
    @Min(value = 1, message = "The value must be positive")
    private Integer price;
    @NotNull(message = "Price number is required")
    @Min(value = 1, message = "The value must be positive")
    private Integer salePrice;
    @NotEmpty(message = "detail is required")
    @Size(min = 10,max = 200)
    private String detail;
    @NotEmpty(message = "Status is required")
    @Size(min = 1,max = 1)
    private String status;
    @NotEmpty(message = "Status is required")
    @Size(min = 1,max = 1)
    private String sex;
    @NotEmpty(message = "Status is required")
    @Size(min = 2,max = 2 ,message = "size 2 char")
    private String sizeProduct;
    private Supplier supplier;
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
