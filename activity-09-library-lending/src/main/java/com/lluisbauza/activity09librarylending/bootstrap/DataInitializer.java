package com.lluisbauza.activity09librarylending.bootstrap;

import com.lluisbauza.activity09librarylending.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookService bookService;
    public DataInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {

        bookService.createBook("Harry Potter", "J.K. Rowling", true);
        bookService.createBook("Game of Thrones", "George R. R. Martin", false);
    }
}
