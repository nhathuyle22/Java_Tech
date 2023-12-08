package com.example.lab09_10.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab09_10.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
