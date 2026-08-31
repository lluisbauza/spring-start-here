package com.lluisbauza.activity12stocktransfer.repository;

import com.lluisbauza.activity12stocktransfer.model.WarehouseStockModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarehouseStockRepository {

    private final JdbcTemplate jdbcTemplate;
    public WarehouseStockRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<WarehouseStockModel> findAll() {
        String sql = "SELECT * FROM warehouse_stock";

        RowMapper<WarehouseStockModel> rowMapper = new BeanPropertyRowMapper<>(WarehouseStockModel.class);

        return jdbcTemplate.query(sql, rowMapper);

    }
}
