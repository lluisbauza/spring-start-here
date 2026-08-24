package com.lluisbauza.activity09librarylending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Integer id;
    private String title;
    private String author;
    private boolean isAvailable;

}
