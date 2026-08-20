package com.lluisbauza.activity09librarylending.exception;

public class BookNotFound extends RuntimeException {
    public BookNotFound(String message) {
        super(message);
    }
}
