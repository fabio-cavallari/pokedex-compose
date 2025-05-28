package com.example.pokedex_compose.presentation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoute(
    val title: String,
) {
    @Serializable
    data object PokemonListScreenRoute : ScreenRoute("PokemonList")
    @Serializable
    data class PokemonDetailScreenRoute(val pokemon: String) : ScreenRoute("PokemonScreen${pokemon}")
}