package com.lluisbauza.activity10pokeapiclient.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
