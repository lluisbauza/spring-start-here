package com.lluisbauza.activity09librarylending.service;

import com.lluisbauza.activity09librarylending.dto.BookResponse;
import com.lluisbauza.activity09librarylending.exception.BookNotFoundException;
import com.lluisbauza.activity09librarylending.factory.BookFactory;
import com.lluisbauza.activity09librarylending.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookFactory bookFactory;
    private final List<Book> books = new ArrayList<>();

    public BookService(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book createBook(String title, String author, boolean isAvailable) {

        var book = bookFactory.createBook(title, author, isAvailable);
        books.add(book);
        return book;

    }

    public BookResponse getBookById(Integer id) {

        Optional<Book> foundBook = books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();

        if (foundBook.isPresent()) {
            return new BookResponse(
                    foundBook.get().getId(),
                    foundBook.get().getTitle(),
                    foundBook.get().getAuthor(),
                    foundBook.get().isAvailable());
        } else {
            throw new BookNotFoundException("Book not found");
        }

    }

    public void setBookNotAvailable(Integer bookId) {

        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.setAvailable(false);
            }
        }

    }

}
