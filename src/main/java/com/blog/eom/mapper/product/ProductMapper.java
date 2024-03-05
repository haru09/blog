package com.blog.eom.mapper.product;

import com.blog.eom.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProductList();
}
