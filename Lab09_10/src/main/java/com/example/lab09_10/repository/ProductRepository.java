package com.example.lab09_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab09_10.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
