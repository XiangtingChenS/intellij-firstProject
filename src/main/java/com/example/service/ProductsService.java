package com.example.service;

import com.example.dao.IProductsDao;
import com.example.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


public class ProductsService implements IProductsService {
    @Autowired
    private IProductsDao productsDao;

    @Override
    public List<ProductsModel> getProducts() {
        return Collections.singletonList(productsDao.getProductsModel());
    }
}
