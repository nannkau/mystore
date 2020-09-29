package com.team.mystore.dto;

import com.team.mystore.entity.Category;
import com.team.mystore.entity.Supplier;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

public class ProductDto {
    private Integer productId;
    @NotEmpty
    private String name;

    private Integer amountTotal;

    private Integer price;

    private String detail;

    private String status;

    private Supplier supplier;

    private Category category;

    private MultipartFile part;
}
