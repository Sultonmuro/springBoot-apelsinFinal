package com.example.springbootapelsinfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetailDto {
    private Integer id;
    private Integer ordId;
    private Integer pr_id;
}
