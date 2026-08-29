package com.lluisbauza.activity10pokeapiclient.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PokemonListResponse {

    final List<PokemonSimpleResponse> pokemonList = new ArrayList<>();

    public void addPokemon(String name) {
        pokemonList.add(new PokemonSimpleResponse(name));
    }

}
