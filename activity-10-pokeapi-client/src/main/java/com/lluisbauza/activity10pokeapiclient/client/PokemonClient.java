package com.lluisbauza.activity10pokeapiclient.client;

import com.lluisbauza.activity10pokeapiclient.dto.external.PokeApiListResponse;
import com.lluisbauza.activity10pokeapiclient.dto.external.PokeApiResponse;
import com.lluisbauza.activity10pokeapiclient.dto.external.PokeApiUnitResponse;
import com.lluisbauza.activity10pokeapiclient.exception.PokeApiException;
import com.lluisbauza.activity10pokeapiclient.exception.PokemonNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class PokemonClient {

    private final RestClient restClient;

    public PokemonClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public PokeApiResponse searchPokemon(Integer id) {
        return restClient
                .get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new PokemonNotFoundException("Pokemon with id " + id + " not found");
                        }
                )
                .onStatus(
                        status -> status.is5xxServerError(),
                        (request, response) -> {
                            throw new PokeApiException("Server error while trying to fetch Pokemon with id " + id);
                        }
                )
                .body(PokeApiResponse.class);
    }

    public PokeApiResponse searchPokemon(String name) {
        return restClient
                .get()
                .uri("/pokemon/{name}", name)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new PokemonNotFoundException("Pokemon named " + name + " not found");
                        }
                )
                .onStatus(
                        status -> status.is5xxServerError(),
                        (request, response) -> {
                            throw new PokeApiException("Server error while trying to fetch Pokemon with name " + name);
                        }
                )
                .body(PokeApiResponse.class);
    }

    public List<PokeApiUnitResponse> getPokemonList(Integer limit, Integer offset) {
        PokeApiListResponse request = restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pokemon")
                        .queryParam("limit", limit)
                        .queryParam("offset", offset)
                        .build())
                .retrieve()
                .body(PokeApiListResponse.class);

        return request.results();
    }

}
