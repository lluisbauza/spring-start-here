package com.lluisbauza.activity13cinemaseatmanager.exception;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(String message) {
        super(message);
    }
}
