package com.lluisbauza.activity13cinemaseatmanager.controller;

import com.lluisbauza.activity13cinemaseatmanager.dto.PriceUpdateRequest;
import com.lluisbauza.activity13cinemaseatmanager.dto.SeatRequest;
import com.lluisbauza.activity13cinemaseatmanager.model.Seat;
import com.lluisbauza.activity13cinemaseatmanager.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getSeats() {
        return seatService.findAllSeats();
    }

    @GetMapping(params = "available=true")
    public List<Seat> findByBookedFalse() {
        return seatService.findByBookedFalse();
    }

    @PostMapping
    public Seat createSeat(@RequestBody SeatRequest seatRequest) {
        return seatService.addSeat(seatRequest);
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.findSeatById(id);
    }

    @PostMapping("/{id}/booking")
    public Seat bookSeat(@PathVariable Long id) {
        return seatService.bookSeat(id);
    }

    @PatchMapping("/{id}/price")
    public Seat updatePrice(@PathVariable Long id, @RequestBody PriceUpdateRequest priceUpdateRequest) {
        return seatService.updatePrice(priceUpdateRequest, id);
    }



}
