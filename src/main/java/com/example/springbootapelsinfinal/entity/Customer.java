package com.example.springbootapelsinfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 14)
    private String name;
    @Column(nullable = false,length = 3)
    private Character country;
    @Column(columnDefinition = "text")
    private String address;
    @Column(length = 50)
    private String phone;
}
