package com.example.ch14.service;

import com.example.ch14.dto.ProductDto;
import com.example.ch14.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}