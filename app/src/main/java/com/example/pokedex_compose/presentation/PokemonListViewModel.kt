package com.example.pokedex_compose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_compose.domain.Pokemon
import com.example.pokedex_compose.data.PokemonListRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel: ViewModel() {
    private val repository = PokemonListRepository()

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private val _pokemonList: MutableStateFlow<List<Pokemon>> = MutableStateFlow(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    private val limit = 10
    private var offset = 0

    init {
        fetchPokemonList()
    }

    fun fetchPokemonList() {
        viewModelScope.launch {
            if (!hasPagination()) {
                return@launch
            }
            setLoadingState()
            repository.getPokemonList(limit, offset)
                .fold(
                    onSuccess = { pokemonList ->
                        val updatedPokemonList = _pokemonList.value.toMutableList()
                        _uiState.value = UiState.Success
                        updatedPokemonList.addAll(pokemonList)
                        _pokemonList.value = updatedPokemonList
                        this@PokemonListViewModel.offset += limit
                    },
                    onFailure = {
                        setErrorState()
                    }
                )
        }
    }

    fun fetchPokemonList(pokemon: Pokemon) {
        viewModelScope.launch {
            repository.getPokemonDetail(pokemon.url)

        }
    }

    fun hasPagination(): Boolean {
//        return offset < 20
        return pokemonList.value.size >= offset
    }

    private fun setLoadingState() {
        if (pokemonList.value.isEmpty()) {
            _uiState.value = UiState.Loading
        } else {
            _uiState.value = UiState.Paging
        }
    }

    private fun setErrorState() {
        if (pokemonList.value.isEmpty()) {
            _uiState.value = UiState.Error
        } else {
            _uiState.value = UiState.PagingError
        }
    }
}