package com.lluisbauza.activity10pokeapiclient.advice;

import com.lluisbauza.activity10pokeapiclient.dto.ErrorDetails;
import com.lluisbauza.activity10pokeapiclient.exception.PokeApiException;
import com.lluisbauza.activity10pokeapiclient.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePokemonNotFound(PokemonNotFoundException e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PokeApiException.class)
    public ResponseEntity<ErrorDetails> handlePokeApiException(PokeApiException e) {
        ErrorDetails error = new ErrorDetails(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }




}
