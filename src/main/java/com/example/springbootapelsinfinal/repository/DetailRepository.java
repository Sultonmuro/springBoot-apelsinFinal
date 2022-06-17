package com.example.springbootapelsinfinal.repository;

import com.example.springbootapelsinfinal.entity.Detail;
import com.example.springbootapelsinfinal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
