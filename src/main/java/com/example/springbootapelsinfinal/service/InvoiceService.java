package com.example.springbootapelsinfinal.service;

import com.example.springbootapelsinfinal.dto.ApiResponse;
import com.example.springbootapelsinfinal.dto.InvoiceDto;
import com.example.springbootapelsinfinal.dto.OrderDto;
import com.example.springbootapelsinfinal.entity.Invoice;
import com.example.springbootapelsinfinal.entity.Order;
import com.example.springbootapelsinfinal.repository.InvoiceRepository;
import com.example.springbootapelsinfinal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service

public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;


    public ApiResponse getAll(){
        List<Invoice> all = invoiceRepository.findAll();
        return ApiResponse.builder().data(all).message("Read all!!!").success(true).build();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Invoice> byId = invoiceRepository.findById(id);
        if(byId!=null){
            Invoice getInvoice = byId.get();
            return ApiResponse.builder().success(true).message("Mana").data(getInvoice).build();
        }else{
            return ApiResponse.builder().success(true).message("Xato!!").build();
        }
    }



    public ApiResponse edit(Integer id, InvoiceDto invoiceDto){
        OrderDto orderDto = new OrderDto();
        Order order = orderRepository.findById(orderDto.getId()).orElseThrow(() -> new RuntimeException("Order not found!"));
        Invoice invoice1 = invoiceRepository.findById(id).ifPresentOrElse(
                invoice -> {
            invoice1.setAmount(invoiceDto.getAmount());
            invoice1.setDate(invoiceDto.getDate());
            invoice1.setOrder(order);
            invoice1.setIssued(invoiceDto.getIssued());
        },() -> new  NullPointerException());
return ApiResponse.builder().success(true).message("Edited Successfully!").build();
    }
    public ApiResponse save(Invoice invoice){
        Invoice save = invoiceRepository.save(invoice);
        if(save!=null){
            return ApiResponse.builder().message("Saved").data(save).success(true).build();
        }else{
            return ApiResponse.builder().message("Error").success(false).data(save).build();
        }
    }
    public ApiResponse delete(@PathVariable Integer id){
        invoiceRepository.deleteById(id);
        return ApiResponse.builder().success(true).message("Deleted!").build();
    }
}
