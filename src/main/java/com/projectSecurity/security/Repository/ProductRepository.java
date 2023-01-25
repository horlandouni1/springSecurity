package com.projectSecurity.security.Repository;

import com.projectSecurity.security.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAll();
    Product getById(Integer id);
    Product save(Product product);
}
