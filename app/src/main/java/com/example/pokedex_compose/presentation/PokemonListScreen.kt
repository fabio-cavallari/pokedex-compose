package com.example.pokedex_compose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun PokemonListScreen(modifier: Modifier = Modifier, navController: NavController) {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemonList by viewModel.pokemonList.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            UiState.Success, UiState.Paging, UiState.PagingError -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(
                        items = pokemonList,
                        key = { index, pokemon -> pokemon.name + index }
                    ) { index, pokemon ->
                        PokemonCard(
                            pokemon = pokemon,
                            index = index,
                        ) {
                            navController.navigate(
                                ScreenRoute.PokemonDetailScreenRoute(
                                    pokemon.name
                                )
                            )
                        }
                    }
                    if (viewModel.hasPagination()) {
                        item {
                            BottomListComponent(
                                uiState = uiState,
                                errorMessage = "",
                                onPaging = viewModel::fetchPokemonList,
                            )
                        }
                    }
                }
            }

            UiState.Loading -> CircularProgressIndicator()
            UiState.Error -> ErrorComponent(message = "ocorreu um erro desconhecido") { viewModel.fetchPokemonList() }
            UiState.Empty -> Text("Lista vazia")
        }
    }
}