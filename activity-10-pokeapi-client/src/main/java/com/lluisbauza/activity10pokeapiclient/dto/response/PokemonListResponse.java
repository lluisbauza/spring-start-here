package com.lluisbauza.activity10pokeapiclient.dto.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PokemonListResponse {

    private final List<PokemonSimpleResponse> pokemonList = new ArrayList<>();

    public void addPokemon(String name) {
        pokemonList.add(new PokemonSimpleResponse(name));
    }

}
