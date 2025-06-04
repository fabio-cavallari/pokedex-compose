package com.example.pokedex_compose.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonTypeSlotDto(
    @JsonProperty("slot") val slot: Int,
    @JsonProperty("type") val type: PokemonTypeDto,
)
