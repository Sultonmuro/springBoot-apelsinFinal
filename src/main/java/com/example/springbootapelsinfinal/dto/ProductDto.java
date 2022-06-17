package com.example.springbootapelsinfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDto {
    private  Integer id;
    private String name;
    private String phone;
    private String photo;
    private String description;
    private Integer cat_id;

}
