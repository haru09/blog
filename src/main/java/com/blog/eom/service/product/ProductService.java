package com.blog.eom.service.product;

import com.blog.eom.domain.product.Product;
import com.blog.eom.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;

    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
}
