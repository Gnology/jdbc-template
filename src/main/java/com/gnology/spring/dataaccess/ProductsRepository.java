package com.gnology.spring.dataaccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class ProductsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(MysqlDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getNumberOfProducts() {
        return jdbcTemplate.queryForObject("select count(*) from products", Integer.class);
    }

    public int getNumberOfProductsWithPriceGreaterThan(double priceLimit) {
        String sql = "SELECT count(*) FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, priceLimit);
    }

    public List<Map<String, Object>> getProductByProductCode(String productCode) {
        String sql = "SELECT productCode, productName, buyPrice FROM products WHERE productCode = ?";
        return jdbcTemplate.queryForList(sql,productCode);
    }

    public List<Map<String, Object>> getProductsWithPriceGreaterThan(double priceLimit) {
        String sql = "SELECT * FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForList(sql, priceLimit);
    }
    public List<Double> getProductPrices() {
        String sql = "SELECT buyPrice FROM  products";
        return jdbcTemplate.queryForList(sql, Double.class);
    }
}
