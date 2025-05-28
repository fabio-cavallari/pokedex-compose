package com.example.pokedex_compose.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDto(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
)
