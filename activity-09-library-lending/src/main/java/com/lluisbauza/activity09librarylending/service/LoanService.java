package com.lluisbauza.activity09librarylending.service;

import com.lluisbauza.activity09librarylending.dto.LoanRequest;
import com.lluisbauza.activity09librarylending.dto.LoanResponse;
import com.lluisbauza.activity09librarylending.exception.BookAlreadyLoanedExeption;
import com.lluisbauza.activity09librarylending.exception.BookNotFound;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private BookService bookService;

    public LoanService(BookService bookService) {
        this.bookService = bookService;
    }

    public LoanResponse getLoanResponse(LoanRequest loanRequest) {

        var book = bookService.getBookById(loanRequest.getBookId());

        if (book == null) {
            throw new BookNotFound("Book with id " + loanRequest.getBookId() + " not found");
        } else if(!book.isAvailable()){
            throw new BookAlreadyLoanedExeption("Book with id " + loanRequest.getBookId() + " not available");
        }

        bookService.setBookNotAvailable(loanRequest.getBookId());

        return new LoanResponse(loanRequest.getBookId(), book.getTitle());

    }

}
