package com.example.dao;

import com.example.model.ProductsModel;
import org.springframework.stereotype.Repository;


public interface IProductsDao {
    ProductsModel getProductsModel();
}
