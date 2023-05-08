package com.microservice.gldproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id){
        return id +"--hello";
    }

}
