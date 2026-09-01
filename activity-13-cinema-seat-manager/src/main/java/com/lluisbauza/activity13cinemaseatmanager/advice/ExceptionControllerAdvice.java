package com.lluisbauza.activity13cinemaseatmanager.advice;

import com.lluisbauza.activity13cinemaseatmanager.dto.ErrorDetails;
import com.lluisbauza.activity13cinemaseatmanager.exception.PriceNotValidException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatAlreadyBookedException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatCodeAlreadyExistsException;
import com.lluisbauza.activity13cinemaseatmanager.exception.SeatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleSeatNotFound(SeatNotFoundException e) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleSeatNotAvailable(SeatAlreadyBookedException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleSeatCodeAlreadyExists(SeatCodeAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handlePriceNotValid(PriceNotValidException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDetails(e.getMessage()));
    }


}
