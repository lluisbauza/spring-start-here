package com.lluisbauza.activity10pokeapiclient.dto.external;

import java.util.List;

public record PokeApiResponse(Integer id, String name, Integer height, Integer weight, List<Types> types) {
}
