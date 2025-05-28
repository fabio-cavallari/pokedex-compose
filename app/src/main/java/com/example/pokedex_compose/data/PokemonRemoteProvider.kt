package com.example.pokedex_compose.data

import retrofit2.Response

class PokemonRemoteProvider {
    private val pokemonClient = NetworkHelper.buildRetrofitClient(PokemonClient::class.java)

    suspend fun getPokemonList(limit: Int, offset: Int) : Response<PokemonResponseDto> {
        return pokemonClient.getPokemonList(limit, offset)
    }
}