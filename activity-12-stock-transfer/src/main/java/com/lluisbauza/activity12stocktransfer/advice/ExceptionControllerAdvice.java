package com.lluisbauza.activity12stocktransfer.advice;

import com.lluisbauza.activity12stocktransfer.dto.ErrorDetails;
import com.lluisbauza.activity12stocktransfer.exception.InvalidQuantityException;
import com.lluisbauza.activity12stocktransfer.exception.NotEnoughStockException;
import com.lluisbauza.activity12stocktransfer.exception.SameStockException;
import com.lluisbauza.activity12stocktransfer.exception.WarehouseStockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(WarehouseStockNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleWarehouseNotFound(
            WarehouseStockNotFoundException e) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler(SameStockException.class)
    public ResponseEntity<ErrorDetails> handleSameWarehouseTransfer(
            SameStockException e) {

        return ResponseEntity
                .badRequest()
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler(NotEnoughStockException.class)
    public ResponseEntity<ErrorDetails> handleNotEnoughStockTransfer(
            NotEnoughStockException e) {

        return ResponseEntity
                .badRequest()
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<ErrorDetails> handleInvalidQuantity(
            InvalidQuantityException e) {

        return ResponseEntity
                .badRequest()
                .body(new ErrorDetails(e.getMessage()));
    }



}
