package com.team.mystore.service.impl;

import com.team.mystore.dto.ProductDto;
import com.team.mystore.dto.SupplierDto;
import com.team.mystore.entity.Product;
import com.team.mystore.entity.Supplier;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.service.ProductService;
import com.team.mystore.utils.UploadUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${upload.path}")
    private String outdir;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos= new ArrayList<>();
        for (Product product:productRepository.findAll()){
            ModelMapper modelMapper= new ModelMapper();
            ProductDto  productDto=modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public Product save(ProductDto productDto) {
        ModelMapper modelMapper= new ModelMapper();
        Product product=modelMapper.map(productDto,Product.class);
        Product temp=productRepository.findById(productDto.getProductId()).get();
        if(temp.getImage()!=null){
            product.setImage(temp.getImage());
        }
        if (productDto.getPart().getSize()>0){
            try {
                product.setImage(UploadUtils.upload(productDto.getPart(),outdir));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto findById(Integer id) {
        ModelMapper modelMapper= new ModelMapper();
        ProductDto productDto=modelMapper.map(productRepository.findById(id).get(),ProductDto.class);
        return productDto ;
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getProductForInvoice(Integer number, String status) {
        return productRepository.getProductByAmountTotalGreaterThanAndStatusEquals(number,status);
    }
}
