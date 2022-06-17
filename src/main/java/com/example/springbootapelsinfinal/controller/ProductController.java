package com.example.springbootapelsinfinal.controller;

import com.example.springbootapelsinfinal.dto.ApiResponse;
import com.example.springbootapelsinfinal.entity.Product;
import com.example.springbootapelsinfinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
    ProductRepository productRepository;
@GetMapping("/read")
    public ApiResponse  readAll(){
    List<Product> productList = productRepository.findAll();
    return ApiResponse.builder().data(productList).message("Read all Successfully").success(true).build();
}
@PostMapping
    public ApiResponse saveProduct(@PathVariable Product product){
Product save = productRepository.save(product);
 if(save!=null){
    return ApiResponse.builder().data(save).message("SAVED SUCCESSFULLY!!!").success(true).build();
 }else{
     return ApiResponse.builder().data(save).success(false).message("Can't save product!").build();
 }
}
@GetMapping("/{id}")
    public  ApiResponse getOneById(@PathVariable Integer id){
    Optional<Product> byId = productRepository.findById(id);
if(byId.isPresent()){
Product product = byId.get();
return ApiResponse.builder().message("Got").success(true).data(product).build();
}else{
    return ApiResponse.builder().message("Mistake").success(false).build();
}
}
@PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody Product product){
    Product editProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product not found!"));
editProduct.setName(product.getName());
    editProduct.setCategory(product.getCategory());
    editProduct.setDescription(product.getDescription());
    editProduct.setPrice(product.getPrice());
  Product save = productRepository.save(editProduct);
  return ApiResponse.builder().success(true).message("Edited").data(save).build();
}
@DeleteMapping
    public ApiResponse delete(@PathVariable Integer id){
    productRepository.deleteById(id);
    return ApiResponse.builder().message("Deleted!").success(true).build();
}
}
