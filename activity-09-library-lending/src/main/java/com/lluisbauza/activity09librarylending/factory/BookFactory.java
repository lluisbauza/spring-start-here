package com.lluisbauza.activity09librarylending.factory;

import com.lluisbauza.activity09librarylending.exception.DataNotValid;
import com.lluisbauza.activity09librarylending.model.Book;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BookFactory {

    private final AtomicInteger count = new AtomicInteger(0);

    public Book createBook(String title, String author, boolean isAvailable) {

        if (title == null || author == null || title.isEmpty() || author.isEmpty()) {

            throw new DataNotValid("Title and author cannot be null");

        }

        Integer id = count.incrementAndGet();
        return new Book(id, title, author, isAvailable);

    }
}
