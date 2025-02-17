package com.security.service;

import com.security.entity.Product;

import java.util.List;

public interface ProductServices {
    void delete(Long id); // Xóa sản phẩm theo ID

    Product get(Long id); // Lấy sản phẩm theo ID

    Product save(Product product); // Lưu sản phẩm

    List<Product> listAll(); // Lấy danh sách tất cả sản phẩm
}

