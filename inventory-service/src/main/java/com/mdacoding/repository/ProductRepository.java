package com.mdacoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mdacoding.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
}
