package com.lluisbauza.activity11movieticketsale.service;

import com.lluisbauza.activity11movieticketsale.model.TicketSale;
import com.lluisbauza.activity11movieticketsale.repository.TicketSaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketSaleService {

    private final TicketSaleRepository ticketSaleRepository;

    public TicketSaleService(TicketSaleRepository ticketSaleRepository) {
        this.ticketSaleRepository = ticketSaleRepository;
    }

    public void save(TicketSale ticketSale) {
        ticketSaleRepository.save(ticketSale);
    }

    public List<TicketSale> getAllTicketSales() {
        return ticketSaleRepository.findAll();
    }
}
