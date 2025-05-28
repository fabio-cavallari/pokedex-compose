package com.example.pokedex_compose.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonResponseDto(
    @JsonProperty("results") val results: List<PokemonDto>,
)
