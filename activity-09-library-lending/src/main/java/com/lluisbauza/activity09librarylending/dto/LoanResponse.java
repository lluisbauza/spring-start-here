package com.lluisbauza.activity09librarylending.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class LoanResponse {

    private Integer bookId;
    private String bookTitle;
    private String message;
    private LocalDate returnDate;

    public LoanResponse(Integer bookId, String bookTitle) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        message = "Loan Confirmed.";
        returnDate = LocalDate.now().plusDays(15);
    }

}
