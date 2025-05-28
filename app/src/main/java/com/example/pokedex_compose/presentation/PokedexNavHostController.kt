package com.example.pokedex_compose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun PokedexNavHostController(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ScreenRoute.PokemonListScreenRoute
    ) {
        composable<ScreenRoute.PokemonListScreenRoute> {
            PokemonListScreen(navController = navHostController)
        }
        composable<ScreenRoute.PokemonDetailScreenRoute> { argument ->
            val pokemonDetailScreenRoute = argument.toRoute<ScreenRoute.PokemonDetailScreenRoute>()
            PokemonDetailScreen(pokemonName = pokemonDetailScreenRoute.pokemon)
        }
    }
}