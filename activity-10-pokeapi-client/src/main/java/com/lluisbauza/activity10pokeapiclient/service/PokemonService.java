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

    public PokemonResponse getPokemonInfo(Integer id) {

        var pokemon = pokemonClient.searchPokemon(id);

        var pokemonTypes = new ArrayList();
        pokemon.types().forEach((type) -> pokemonTypes.add(type.type().name()));

        return new PokemonResponse(
                pokemon.id(),
                pokemon.name(),
                pokemon.height(),
                pokemon.weight(),
                pokemonTypes
        );

    }

    public PokemonResponse getPokemonInfo(String name) {

        var pokemon = pokemonClient.searchPokemon(name);

        var pokemonTypes = new ArrayList<String>();
        pokemon.types().forEach((type) -> pokemonTypes.add(type.type().name()));

        return new PokemonResponse(
                pokemon.id(),
                pokemon.name(),
                pokemon.weight(),
                pokemon.height(),
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
