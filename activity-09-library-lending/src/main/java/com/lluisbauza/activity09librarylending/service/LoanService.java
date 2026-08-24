package com.lluisbauza.activity09librarylending.service;

import com.lluisbauza.activity09librarylending.dto.LoanRequest;
import com.lluisbauza.activity09librarylending.dto.LoanResponse;
import com.lluisbauza.activity09librarylending.exception.BookAlreadyLoanedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    private final BookService bookService;

    public LoanService(BookService bookService) {
        this.bookService = bookService;
    }

    public LoanResponse makeLoan(LoanRequest loanRequest) {

        var book = bookService.getBookById(loanRequest.getBookId());

        if(!book.isAvailable()){
            throw new BookAlreadyLoanedException("Book with id " + loanRequest.getBookId() + " not available");
        }

        bookService.setBookNotAvailable(loanRequest.getBookId());

        return new LoanResponse(loanRequest.getBookId(), book.getTitle(), "Loan Confirmed.", LocalDate.now().plusDays(15));

    }

}
