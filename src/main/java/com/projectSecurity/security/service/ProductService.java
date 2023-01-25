package com.projectSecurity.security.service;

import com.projectSecurity.security.Repository.ProductRepository;
import com.projectSecurity.security.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(Integer id){
        return productRepository.getById(id);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
}
