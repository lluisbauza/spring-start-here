package com.lluisbauza.activity12stocktransfer.repository;

import com.lluisbauza.activity12stocktransfer.model.WarehouseStock;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WarehouseStockRepository {

    private final JdbcTemplate jdbc;
    public WarehouseStockRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<WarehouseStock> findAll() {
        String sql = "SELECT * FROM warehouse_stock";

        RowMapper<WarehouseStock> rowMapper = new BeanPropertyRowMapper<>(WarehouseStock.class);

        return jdbc.query(sql, rowMapper);

    }

    public Optional<WarehouseStock> findById(Integer id) {
        String sql = "SELECT * FROM warehouse_stock WHERE id = ?";

        return jdbc.query(sql, new WarehouseStockRowMapper(), id)
                .stream()
                .findFirst();
    }

    public void changeStock(Integer id, Integer quantity) {
        String sql = "UPDATE warehouse_stock SET quantity = ? WHERE id = ?";
        jdbc.update(sql, quantity, id);
    }
}
