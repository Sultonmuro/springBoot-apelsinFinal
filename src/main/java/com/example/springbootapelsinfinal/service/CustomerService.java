package com.example.springbootapelsinfinal.service;

import com.example.springbootapelsinfinal.dto.ApiResponse;
import com.example.springbootapelsinfinal.entity.Customer;
import com.example.springbootapelsinfinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public ApiResponse readAll() {
        List<Customer> customerList = customerRepository.findAll();
        return ApiResponse.builder().message("read").success(true).data(customerList).build();
    }

    public ApiResponse getOne(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId != null) {
            Customer customer = byId.get();
            return ApiResponse.builder().data(customer).success(true).message("Got!").build();
        } else {
            return ApiResponse.builder().message("Error").success(false).build();
        }
    }

    public ApiResponse edit(Integer id, Customer customer) {
        Customer customer1 = customerRepository.findById(id).orElseThrow(() -> new RuntimeException());
customer1.setName(customer.getName());
customer1.setAddress(customer.getAddress());
customer1.setCountry(customer.getCountry());
customer1.setPhone(customer.getPhone());
  Customer save = customerRepository.save(customer1);
  return ApiResponse.builder().success(true).message("Mana").data(save).build();

    }

    public ApiResponse save(Customer customer) {
        Customer save = customerRepository.save(customer);
        if(save!=null){

            return ApiResponse.builder().message("Saved").success(true).build();
        }else{
            return ApiResponse.builder().success(false).message("Error").build();
        }
    }

    public ApiResponse delete(Integer id) {
        customerRepository.deleteById(id);
        return ApiResponse.builder().success(true).message("Deleted").build();

    }
}
