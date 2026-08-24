package com.lluisbauza.activity09librarylending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LoanResponse {

    private Integer bookId;
    private String bookTitle;
    private String message;
    private LocalDate returnDate;

}
