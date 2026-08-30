package com.lluisbauza.activity11movieticketsale.repository;

import com.lluisbauza.activity11movieticketsale.model.TicketSale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketSaleRepository {

    private final JdbcTemplate jdbc;
    public TicketSaleRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(TicketSale ticketSale) {

        String sql = "INSERT INTO ticket_sale (movie_title, ticket_price, seats_sold) " +
                "VALUES (?, ?, ?)";

        jdbc.update(sql,
                ticketSale.getMovieTitle(),
                ticketSale.getTicketPrice(),
                ticketSale.getSeatsSold());
    }

    public List<TicketSale> findAll() {
        String sql = "SELECT * FROM ticket_sale;";

//        Also a valid way to do it (does the mapping on its own)
//        RowMapper<TicketSale> rowMapper = new BeanPropertyRowMapper<>(TicketSale.class);

//
//        rs is the ResultSet (object in JDBC) containing the data returned by the query
//        For each row, with rowNum as its index, the lambda creates and returns a TicketSale

        RowMapper<TicketSale> rowMapper = (rs, rowNum) -> {
            TicketSale ticketSale = new TicketSale();
            ticketSale.setId(rs.getInt("id"));
            ticketSale.setMovieTitle(rs.getString("movie_title"));
            ticketSale.setTicketPrice(rs.getBigDecimal("ticket_price"));
            ticketSale.setSeatsSold(rs.getInt("seats_sold"));
            return ticketSale;
        };

        return jdbc.query(sql, rowMapper);
    }
}

