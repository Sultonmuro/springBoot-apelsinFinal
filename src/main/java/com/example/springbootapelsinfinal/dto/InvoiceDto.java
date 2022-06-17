package com.example.springbootapelsinfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceDto {
    private Integer id;
    private Integer ord_id;
    private BigDecimal amount;
    private Date issued;
    private java.sql.Date date;
}
