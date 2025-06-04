package com.example.pokedex_compose.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonTypeDto(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
)
