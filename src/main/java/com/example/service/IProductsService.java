package com.example.service;

import com.example.model.ProductsModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductsService {
    //test
    List<ProductsModel> getProducts();
}
