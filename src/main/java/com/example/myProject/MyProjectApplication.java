package com.example.myProject;


import com.example.model.ProductsModel;
import com.example.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.example.service", "com.example.dao"})
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }

    @Autowired
    private IProductsService productsService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {

        StringBuilder str = new StringBuilder();
        productsService.getProducts().forEach(v -> str.append(v.getName()).append(", ").append(v.getDescription()).append(", ").append(v.getPrice()).append("!!!!!!!! "));
        List<ProductsModel> products = productsService.getProducts();
//        for (ProductsModel product : products) {
//            str.append(product.getName()).append(", ").append(product.getDescription()).append(", ").append(product.getPrice());
//        }

        return String.format("Hello, %s! %s", name, str);
    }


}
