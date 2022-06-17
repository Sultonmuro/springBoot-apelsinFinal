package com.example.springbootapelsinfinal.repository;

import com.example.springbootapelsinfinal.entity.Customer;
import com.example.springbootapelsinfinal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
