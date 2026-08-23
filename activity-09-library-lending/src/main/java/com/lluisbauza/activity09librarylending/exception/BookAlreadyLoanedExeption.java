package com.lluisbauza.activity09librarylending.exception;

public class BookAlreadyLoanedExeption extends RuntimeException {
    public BookAlreadyLoanedExeption(String message) {
        super(message);
    }
}
