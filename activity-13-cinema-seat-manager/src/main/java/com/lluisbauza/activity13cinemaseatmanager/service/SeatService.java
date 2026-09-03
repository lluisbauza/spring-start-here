package com.lluisbauza.activity13cinemaseatmanager.service;

import com.lluisbauza.activity13cinemaseatmanager.dto.PriceUpdateRequest;
import com.lluisbauza.activity13cinemaseatmanager.dto.SeatRequest;
import com.lluisbauza.activity13cinemaseatmanager.exception.PriceNotValidException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatAlreadyBookedException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatCodeAlreadyExistsException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatNotFoundException;
import com.lluisbauza.activity13cinemaseatmanager.model.Seat;
import com.lluisbauza.activity13cinemaseatmanager.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat addSeat(SeatRequest seatRequest) {

        if (seatRepository.existsByCode(seatRequest.code())) {
            throw new SeatCodeAlreadyExistsException("Code already exists");
        }

        if (seatRequest.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceNotValidException("Price must be greater than zero");
        }

        var seat = new Seat();
        seat.setCode(seatRequest.code());
        seat.setPrice(seatRequest.price());

        return seatRepository.save(seat);

    }

    public List<Seat> findAllSeats() {
        return seatRepository.findAll();
    }

    public List<Seat> getAvailableSeats() {
        return seatRepository.findByBookedFalse();
    }

    public Seat findSeatById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new SeatNotFoundException("Seat with id " + id + " not found"));
    }

    public List<Seat> findByBookedFalse() {
        return seatRepository.findByBookedFalse();
    }

    @Transactional
    public Seat updatePrice(PriceUpdateRequest priceUpdateRequest, Long id) {

        var price = priceUpdateRequest.price();

        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceNotValidException("Price must be greater than zero");
        }

        if (seatRepository.updatePrice(price, id) == 1) {
            return findSeatById(id);
        }

        throw new SeatNotFoundException("Seat with id " + id + " not found");

    }

    @Transactional
    public Seat bookSeat(Long id) {

        var seat = findSeatById(id);

        if  (seat == null) {
            throw new SeatNotFoundException("Seat with id " + id + " not found");
        }

        if (seat.isBooked()) {
            throw new SeatAlreadyBookedException("Seat with id " + id + " is already booked");
        }

        seat.setBooked(true);

        return seat;

    }

}
