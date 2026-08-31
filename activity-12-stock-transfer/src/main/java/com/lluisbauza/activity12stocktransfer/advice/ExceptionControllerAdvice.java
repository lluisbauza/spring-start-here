package com.lluisbauza.activity12stocktransfer.advice;

import com.lluisbauza.activity12stocktransfer.dto.ErrorDetails;
import com.lluisbauza.activity12stocktransfer.exception.NotEnoughStockException;
import com.lluisbauza.activity12stocktransfer.exception.SameWarehouseException;
import com.lluisbauza.activity12stocktransfer.exception.WarehouseDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(WarehouseDoesNotExistException.class)
    public ResponseEntity<ErrorDetails> handleWarehouseNotFound(
            WarehouseDoesNotExistException e) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDetails(e.getMessage()));
    }

    @ExceptionHandler(SameWarehouseException.class)
    public ResponseEntity<ErrorDetails> handleSameWarehouseTransfer(
            SameWarehouseException e) {

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


}
