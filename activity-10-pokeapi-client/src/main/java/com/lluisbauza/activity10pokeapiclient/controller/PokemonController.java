package com.lluisbauza.activity10pokeapiclient.controller;

import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonListResponse;
import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonResponse;
import com.lluisbauza.activity10pokeapiclient.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{idOrName}")
    public PokemonResponse getPokemons(
            @PathVariable String idOrName
    ) {
        return pokemonService.getPokemonInfo(idOrName);
    }

    @GetMapping
    public PokemonListResponse getPokemons(
            @RequestParam(defaultValue = "0", required = false) Integer limit,
            @RequestParam(defaultValue = "0", required = false) Integer offset
    ) {
        return pokemonService.getPokemons(limit, offset);
    }
}
