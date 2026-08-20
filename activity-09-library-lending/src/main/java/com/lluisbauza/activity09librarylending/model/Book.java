package com.lluisbauza.activity09librarylending.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public Integer id;
    public String title;
    public String author;
    public String availability;

    public Book(String title, String author, String availability) {
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

}
