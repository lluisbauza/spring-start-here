package com.lluisbauza.activity09librarylending.factory;

import com.lluisbauza.activity09librarylending.exception.DataNotValidException;
import com.lluisbauza.activity09librarylending.model.Book;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BookFactory {

    private final AtomicInteger count = new AtomicInteger(0);

    public Book createBook(String title, String author, boolean isAvailable) {

        if (title == null || author == null || title.isEmpty() || author.isEmpty()) {

            throw new DataNotValidException("Title and author are empty or null");

        }

        Integer id = count.incrementAndGet();
        return new Book(id, title, author, isAvailable);

    }
}
