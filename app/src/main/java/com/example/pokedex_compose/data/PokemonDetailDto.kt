package com.example.pokedex_compose.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDetailDto(
    @JsonProperty("types") val types: List<PokemonTypeSlotDto>,
)
