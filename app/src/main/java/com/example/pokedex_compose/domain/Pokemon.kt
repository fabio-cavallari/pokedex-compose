package com.example.pokedex_compose.domain

import com.example.pokedex_compose.data.PokemonDto

data class Pokemon(
    val name: String,
)

fun PokemonDto.asDomainModel() : Pokemon = Pokemon(name)

fun List<PokemonDto>.asDomainModel() = map { it.asDomainModel() }