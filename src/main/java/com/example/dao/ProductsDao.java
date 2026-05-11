package com.example.dao;

import com.example.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsDao implements IProductsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProductsModel getProductsModel() {
        return jdbcTemplate.queryForObject("select * from products", (rs, rowNum) -> new ProductsModel());
//        int total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employee", Integer.class);
//        return null;
    }
}
