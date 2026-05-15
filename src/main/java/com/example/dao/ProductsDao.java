package com.example.dao;

import com.example.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDao implements IProductsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductsModel> getProductsModel() {
        int total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products", Integer.class);
        System.out.println("total : " + total);


        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new ProductsModel(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price")
        ));


    }
}
