package com.mdacoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdacoding.entity.Product;
import com.mdacoding.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    // update the stock of a product in inventory stock
    public Product updateStock(int id, int stock) {

        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));

        existingProduct.setStock(stock);
        return repository.save(existingProduct);
    }

    // receive new shipment
    public Product receiveNewShipment(int id, int quantity) {

        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));

        existingProduct.setStock(existingProduct.getStock() + quantity);
        return repository.save(existingProduct);
    }

}
