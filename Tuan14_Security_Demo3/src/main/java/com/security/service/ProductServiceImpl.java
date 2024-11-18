package com.security.service;

import com.security.entity.Product;
import com.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository repo;

    // Constructor injection
    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).orElse(null); // Tránh NoSuchElementException
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
