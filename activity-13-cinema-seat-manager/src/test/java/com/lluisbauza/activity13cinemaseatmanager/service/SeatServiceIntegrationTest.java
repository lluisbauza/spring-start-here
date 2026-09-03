package com.lluisbauza.activity13cinemaseatmanager.service;

import com.lluisbauza.activity13cinemaseatmanager.dto.PriceUpdateRequest;
import com.lluisbauza.activity13cinemaseatmanager.dto.SeatRequest;
import com.lluisbauza.activity13cinemaseatmanager.exception.PriceNotValidException;
import com.lluisbauza.activity13cinemaseatmanager.model.Seat;
import com.lluisbauza.activity13cinemaseatmanager.repository.SeatRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class SeatServiceIntegrationTest {

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void addSeat_happyPath() {

        //Arrange
        SeatRequest request = new SeatRequest(
                "A1",
                BigDecimal.valueOf(10)
        );

        //Act
        Seat savedSeat = seatService.addSeat(request);


        //Assert
        entityManager.flush();
        entityManager.clear();

        Seat persistedSeat = seatRepository
                .findById(savedSeat.getId())
                .orElseThrow();

        assertEquals("A1", persistedSeat.getCode());
        assertEquals(
                0,
                BigDecimal.valueOf(10).compareTo(persistedSeat.getPrice())
        );
        assertFalse(persistedSeat.isBooked());

    }

    @Test
    void bookSeat_happyPath() {

        //Arrange
        Seat seat = new Seat();
        seat.setCode("A2");
        seat.setBooked(false);
        seat.setPrice(BigDecimal.valueOf(10));

        Seat savedSeat = seatRepository.save(seat);

        //Act
        Seat bookedSeat = seatService.bookSeat(savedSeat.getId());

        //Assert
        assertEquals("A2", bookedSeat.getCode());
        assertTrue(bookedSeat.isBooked());

        //Verify persistence in DB / Clear caché
        entityManager.flush();
        entityManager.clear();

        Seat persistedSeat = seatRepository
                .findById(savedSeat.getId())
                .orElseThrow();

        assertTrue(persistedSeat.isBooked());
    }

    @Test
    void updatePrice_negativePrice_throwsExceptionAndKeepsOriginalPrice() {

        //Arrange
        Seat seat = new Seat();
        seat.setCode("A2");
        seat.setBooked(false);
        seat.setPrice(BigDecimal.valueOf(10));

        Seat savedSeat = seatRepository.save(seat);

        PriceUpdateRequest request = new PriceUpdateRequest(
                BigDecimal.valueOf(-15)
        );

        // Act + Assert
        assertThrows(
                PriceNotValidException.class,
                () -> seatService.updatePrice(request, savedSeat.getId())
        );

        entityManager.flush();
        entityManager.clear();

        Seat persistedSeat = seatRepository
                .findById(savedSeat.getId())
                .orElseThrow();

        //new BigDecimal("10.0").compareTo(new BigDecimal("10.00")) = 0
        assertEquals(
                0,
                BigDecimal.valueOf(10).compareTo(persistedSeat.getPrice())
        );


    }

    @Test
    void getAvailableSeats_happyPath() {
        // Arrange
        Seat available1 = new Seat();
        available1.setCode("A1");
        available1.setBooked(false);
        available1.setPrice(BigDecimal.valueOf(10));

        Seat available2 = new Seat();
        available2.setCode("A2");
        available2.setBooked(false);
        available2.setPrice(BigDecimal.valueOf(10));

        Seat booked = new Seat();
        booked.setCode("A3");
        booked.setBooked(true);
        booked.setPrice(BigDecimal.valueOf(10));

        seatRepository.saveAll(List.of(
                available1,
                available2,
                booked
        ));

        entityManager.flush();
        entityManager.clear();

        //Act
        List<Seat> availableSeats = seatService.getAvailableSeats();

        //Assert
        assertEquals(2, availableSeats.size());
        assertTrue(availableSeats.stream().noneMatch(Seat::isBooked));
    }


}