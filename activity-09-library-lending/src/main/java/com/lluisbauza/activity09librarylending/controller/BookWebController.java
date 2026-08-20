package com.lluisbauza.activity09librarylending.controller;

import com.lluisbauza.activity09librarylending.dto.BookRequest;
import com.lluisbauza.activity09librarylending.dto.BookResponse;
import com.lluisbauza.activity09librarylending.model.Book;
import com.lluisbauza.activity09librarylending.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookWebController {

    private BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable BookRequest bookRequest) {
        return bookService.getBookById(bookRequest);
    }

}
