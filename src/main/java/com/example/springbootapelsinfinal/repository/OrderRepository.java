package com.example.springbootapelsinfinal.repository;

import com.example.springbootapelsinfinal.entity.Order;
import com.example.springbootapelsinfinal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
