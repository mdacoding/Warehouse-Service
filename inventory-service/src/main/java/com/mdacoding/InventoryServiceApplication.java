package com.mdacoding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mdacoding.entity.Product;
import com.mdacoding.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class InventoryServiceApplication {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void initDB() {
        List<Product> products = Stream.of(
                new Product("Notebook", "Electronics", 849.99f, 1000),
                new Product("Laptop", "Electronics", 1399.99f, 250),
                new Product("Smartphone", "Electronics", 749.99f, 800),
                new Product("Couch", "Furniture", 4999.99f, 150),
                new Product("Gaming Chair", "Furniture", 429.99f, 400)
        ).collect(Collectors.toList());
        repository.saveAll(products);
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

}
