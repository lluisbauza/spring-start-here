package com.lluisbauza.activity09librarylending.advice;

import com.lluisbauza.activity09librarylending.dto.ErrorDetails;
import com.lluisbauza.activity09librarylending.exception.BookAlreadyLoanedException;
import com.lluisbauza.activity09librarylending.exception.BookNotFoundException;
import com.lluisbauza.activity09librarylending.exception.DataNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFound(BookNotFoundException e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotValidException.class)
    public ResponseEntity<ErrorDetails> handleDataNotValid(DataNotValidException e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookAlreadyLoanedException.class)
    public ResponseEntity<ErrorDetails> handleBookAlreadyLoaned(BookAlreadyLoanedException e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
