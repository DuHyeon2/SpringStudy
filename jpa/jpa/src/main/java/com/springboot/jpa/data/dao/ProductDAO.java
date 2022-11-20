package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Product;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProductName(Long number);

    Product updateProduct(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
