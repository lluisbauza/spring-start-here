package com.lluisbauza.activity10pokeapiclient.service;

import com.lluisbauza.activity10pokeapiclient.client.PokemonClient;
import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonListResponse;
import com.lluisbauza.activity10pokeapiclient.dto.response.PokemonResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public PokemonResponse getPokemonInfo(String idOrName) {

        var pokemon = pokemonClient.searchPokemon(idOrName);

        var pokemonTypes = new ArrayList<String>();
        pokemon.types().forEach((type) -> pokemonTypes.add(type.type().name()));

        return new PokemonResponse(
                pokemon.id(),
                pokemon.name(),
                pokemon.height(),
                pokemon.weight(),
                pokemonTypes
        );

    }

    public PokemonListResponse getPokemons(Integer limit, Integer offset) {

        var pokemonsOriginal = pokemonClient.getPokemonList(limit, offset);

        var pokemons = new PokemonListResponse();

        pokemonsOriginal.forEach(pokemon -> pokemons.addPokemon(pokemon.name()));

        return pokemons;

    }


}
