package com.lluisbauza.activity11movieticketsale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketSale {
    private Integer id;
    private String movieTitle;
    private BigDecimal ticketPrice;
    private Integer seatsSold;
}
