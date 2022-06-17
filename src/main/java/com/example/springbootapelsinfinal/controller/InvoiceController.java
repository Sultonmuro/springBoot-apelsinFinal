package com.example.springbootapelsinfinal.controller;

import com.example.springbootapelsinfinal.dto.ApiResponse;
import com.example.springbootapelsinfinal.dto.InvoiceDto;
import com.example.springbootapelsinfinal.dto.OrderDto;
import com.example.springbootapelsinfinal.entity.Invoice;
import com.example.springbootapelsinfinal.repository.InvoiceRepository;
import com.example.springbootapelsinfinal.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @GetMapping("/getAll")
    public ApiResponse readAll(){
 return invoiceService.getAll();
    }
    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id){
       return invoiceService.getOne(id);
    }
    @PostMapping("{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody InvoiceDto invoiceDto){
      return  invoiceService.edit(id,invoiceDto);
    }
    @PostMapping
    public ApiResponse save(@RequestBody Invoice invoice){
      return  invoiceService.save(invoice);
    }
    @DeleteMapping
    public ApiResponse delete(@PathVariable Integer id){
        return invoiceService.delete(id);
    }
}
