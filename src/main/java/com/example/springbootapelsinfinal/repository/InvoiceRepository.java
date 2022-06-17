package com.example.springbootapelsinfinal.repository;

import com.example.springbootapelsinfinal.entity.Invoice;
import com.example.springbootapelsinfinal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
