package com.lluisbauza.activity10pokeapiclient.dto.response;

import java.util.List;

public record PokemonResponse(Integer id, String name, Integer height, Integer weight, List<String> types) {
}
