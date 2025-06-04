package com.example.pokedex_compose.domain

import com.example.pokedex_compose.data.PokemonDto

data class Pokemon(
    val name: String,
    val url: String,
    val types: List<Type> = emptyList()
)

fun PokemonDto.asDomainModel() : Pokemon = Pokemon(name, url)

fun List<PokemonDto>.asDomainModel() = map { it.asDomainModel() }