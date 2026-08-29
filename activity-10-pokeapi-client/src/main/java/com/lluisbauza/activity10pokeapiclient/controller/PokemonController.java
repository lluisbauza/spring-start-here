package com.lluisbauza.activity10pokeapiclient.controller;

import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonListResponse;
import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonResponse;
import com.lluisbauza.activity10pokeapiclient.service.PokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{idOrName}")
    public PokemonResponse getPokemon(
            @PathVariable String idOrName
    ) {
        return pokemonService.getPokemonInfo(idOrName);
    }

    @GetMapping
    public PokemonListResponse getPokemons(
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset
    ) {
        return pokemonService.getPokemons(limit, offset);
    }
}
