package com.lluisbauza.activity11movieticketsale.controller;

import com.lluisbauza.activity11movieticketsale.model.TicketSale;
import com.lluisbauza.activity11movieticketsale.service.TicketSaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket-sales")
public class TicketSaleController {

    private final TicketSaleService ticketSaleService;

    public TicketSaleController(TicketSaleService ticketSaleService) {
        this.ticketSaleService = ticketSaleService;
    }

    @PostMapping
    public void createTicketSale(@RequestBody TicketSale ticketSale) {
        ticketSaleService.save(ticketSale);
    }

    @GetMapping
    public List<TicketSale> getAllTicketSales() {
        return ticketSaleService.getAllTicketSales();
    }
}
