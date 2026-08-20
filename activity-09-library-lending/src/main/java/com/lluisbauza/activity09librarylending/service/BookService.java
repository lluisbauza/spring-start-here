package com.lluisbauza.activity09librarylending.service;

import com.lluisbauza.activity09librarylending.dto.BookRequest;
import com.lluisbauza.activity09librarylending.dto.BookResponse;
import com.lluisbauza.activity09librarylending.exception.BookNotFound;
import com.lluisbauza.activity09librarylending.factory.BookFactory;
import com.lluisbauza.activity09librarylending.model.Book;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Service
public class BookService {

    private final BookFactory bookFactory;
    private List<Book> books = new ArrayList<>();

    public BookService(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }

    public Book createBook(String title, String author, String availability) {

        var book = bookFactory.createBook(title, author, availability);
        books.add(book);
        return book;

    }

    public BookResponse getBookById(BookRequest bookRequest) {

        Optional<Book> foundBook = books.stream()
                .filter(book -> book.getId() == bookRequest.getBookId())
                .findFirst();

        if (foundBook.isPresent()) {
            return new BookResponse(
                    foundBook.get().getTitle(),
                    foundBook.get().getAuthor(),
                    foundBook.get().getAvailability());
        } else {
            throw new BookNotFound("Book not found");
        }

    }

}
