package com.lluisbauza.activity09librarylending.controller;

import com.lluisbauza.activity09librarylending.dto.LoanRequest;
import com.lluisbauza.activity09librarylending.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanRestController {

    private final LoanService loanService;
    public LoanRestController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<?> loanRequest(@RequestBody LoanRequest loanRequest) {

        var loanResponse = loanService.getLoanResponse(loanRequest);

        if (loanResponse == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity
                .accepted()
                .header("due-date", loanResponse.getReturnDate().toString())
                .body(loanResponse);
    }
}
