package com.example.springbootapelsinfinal.controller;

import com.example.springbootapelsinfinal.dto.ApiResponse;
import com.example.springbootapelsinfinal.entity.Customer;
import com.example.springbootapelsinfinal.repository.CustomerRepository;
import com.example.springbootapelsinfinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/getAll")
    public ApiResponse readCustomer(){
     return   customerService.readAll();
    }
    @GetMapping("/getOne")
    public ApiResponse getOne(@PathVariable Integer id){
      return  customerService.getOne(id);
    }
    @PostMapping("edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody  Customer customer){
       return customerService.edit(id,customer);
    }
    @PostMapping
    public ApiResponse save(@RequestBody Customer customer){
        return  customerService.save(customer);
    }
    @DeleteMapping("delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return customerService.delete();
    }

}
