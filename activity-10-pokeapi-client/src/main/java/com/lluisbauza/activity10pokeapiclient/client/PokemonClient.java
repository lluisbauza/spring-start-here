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

    public PokeApiResponse searchPokemon(String idOrName) {
        return restClient
                .get()
                .uri("/pokemon/{idOrName}", idOrName)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new PokemonNotFoundException("Pokemon with id or name " + idOrName + " not found");
                        }
                )
                .onStatus(
                        status -> status.is5xxServerError(),
                        (request, response) -> {
                            throw new PokeApiException("Server error while trying to fetch Pokemon with id or name " + idOrName);
                        }
                )
                .body(PokeApiResponse.class);
    }

    public List<PokeApiUnitResponse> getPokemonList(Integer limit, Integer offset) {
        PokeApiListResponse listResponse = restClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/pokemon")
                        .queryParam("limit", limit)
                        .queryParam("offset", offset)
                        .build())
                .retrieve()
                .onStatus(
                        status -> status.is5xxServerError(),
                        (request, response) -> {
                            throw new PokeApiException("Server error");
                        }
                )
                .body(PokeApiListResponse.class);

        return listResponse.results();
    }

}
