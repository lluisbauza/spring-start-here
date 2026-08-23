package com.lluisbauza.activity09librarylending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private String title;
    private String author;
    private boolean isAvailable;

}
