package com.lluisbauza.activity10pokeapiclient.controller;

import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonListResponse;
import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonResponse;
import com.lluisbauza.activity10pokeapiclient.service.PokemonService;
import org.springframework.web.bind.annotation.*;

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
        if (Integer.parseInt(idOrName) == 0) {
            return pokemonService.getPokemonInfo(Integer.parseInt(idOrName));
        }
        return pokemonService.getPokemonInfo(idOrName);
    }

    @GetMapping
    public PokemonListResponse getPokemons(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer offset
    ) {
        return pokemonService.getPokemons(limit, offset);
    }
}
