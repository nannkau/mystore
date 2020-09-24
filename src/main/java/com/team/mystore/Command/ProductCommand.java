package com.team.mystore.Command;

import com.team.mystore.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public class ProductCommand extends AbstractCommand<Product> {
    private MultipartFile part;
    public MultipartFile getPart() {
        return part;
    }

    public void setPart(MultipartFile part) {
        this.part = part;
    }
}
