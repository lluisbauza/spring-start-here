package com.lluisbauza.activity13cinemaseatmanager.service;

import com.lluisbauza.activity13cinemaseatmanager.dto.SeatRequest;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatAlreadyBookedException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatCodeAlreadyExistsException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatNotFoundException;
import com.lluisbauza.activity13cinemaseatmanager.model.Seat;
import com.lluisbauza.activity13cinemaseatmanager.repository.SeatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SeatServiceTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatService seatService;

    @Test
    public void addSeat_happyPath() {

        //Arrange
        SeatRequest seatRequest = new SeatRequest(
                "A1", BigDecimal.valueOf(10)
        );

        given(seatRepository.existsByCode(seatRequest.code()))
                .willReturn(false);

        given(seatRepository.save(any(Seat.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        //Act
        Seat result = seatService.addSeat(seatRequest);

        //Assert
        assertEquals("A1", result.getCode());
        assertEquals(BigDecimal.valueOf(10), result.getPrice());

        verify(seatRepository).existsByCode(seatRequest.code());
        verify(seatRepository).save(any(Seat.class));
    }

    @Test
    void addSeat_wrongCode_throwsException() {
        //Arrange
        SeatRequest seatRequest = new SeatRequest(
                "A1", BigDecimal.valueOf(10)
        );

        given(seatRepository.existsByCode(seatRequest.code()))
                .willReturn(true);

        // Act + Assert
        // In this case, the assertThrows executes the ACT itself
        assertThrows(
                SeatCodeAlreadyExistsException.class,
                () -> seatService.addSeat(seatRequest)
        );

        verify(seatRepository, never())
            .save(any(Seat.class));
    }

    @Test
    public void bookSeat_happyPath() {

        //Arrange
        Seat seat = new Seat();
        seat.setBooked(false);

        //Act
        seatService.bookSeat(seat.getId());

        //Assert
        assertTrue(seat.isBooked());

    }

    @Test
    void bookSeat_alreadyBookedSeat_throwsException() {

        //Arrange
        Long id = 1L;

        Seat seat = new Seat();
        seat.setId(id);
        seat.setBooked(true);

        given(seatRepository.findById(id))
                .willReturn(Optional.of(seat));

        //Act
        assertThrows(
                SeatAlreadyBookedException.class,
                () -> seatService.bookSeat(seat.getId())
        );

        verify(seatRepository).findById(id);
        verify(seatRepository, never()).save(any(Seat.class));

    }

    @Test
    void bookSeat_seatNotFound_throwsException() {

        //Arrange
        Long id = 999L;

        given(seatRepository.findById(id))
                .willReturn(Optional.empty());

        // Act + Assert
        assertThrows(
                SeatNotFoundException.class,
                () -> seatService.bookSeat(id)
        );

        verify(seatRepository).findById(id);
    }



}
