package com.lluisbauza.activity13cinemaseatmanager.exception;

public class SeatCodeAlreadyExistsException extends RuntimeException {
    public SeatCodeAlreadyExistsException(String message) {
        super(message);
    }
}
