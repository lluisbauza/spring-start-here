package com.lluisbauza.activity11movieticketsale.repository;

import com.lluisbauza.activity11movieticketsale.model.TicketSale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketSaleRepository {

    public final JdbcTemplate jdbc;
    public TicketSaleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(TicketSale ticketSale) {

        String sql = "INSERT INTO ticket_sale (movieTitle, ticketPrice, seatsSold) " +
                "VALUES (?, ?, ?)";

        jdbc.update(sql,
                ticketSale.getMovieTitle(),
                ticketSale.getTicketPrice(),
                ticketSale.getSeatsSold());
    }

    public List<TicketSale> findAll() {
        String sql = "SELECT * FROM ticket_sale;";
        RowMapper<TicketSale> rowMapper = new BeanPropertyRowMapper<>(TicketSale.class);

        return jdbc.query(sql, rowMapper);
    }
}

