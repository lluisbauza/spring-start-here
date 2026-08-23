package com.lluisbauza.activity09librarylending.advice;

import com.lluisbauza.activity09librarylending.dto.ErrorDetails;
import com.lluisbauza.activity09librarylending.exception.BookAlreadyLoanedExeption;
import com.lluisbauza.activity09librarylending.exception.BookNotFound;
import com.lluisbauza.activity09librarylending.exception.DataNotValid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ErrorDetails> handleBookNotFound(BookNotFound e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotValid.class)
    public ResponseEntity<ErrorDetails> handleDataNotValid(DataNotValid e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookAlreadyLoanedExeption.class)
    public ResponseEntity<ErrorDetails> handleDataNotValid(BookAlreadyLoanedExeption e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
