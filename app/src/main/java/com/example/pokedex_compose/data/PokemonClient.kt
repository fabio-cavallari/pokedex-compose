package com.example.pokedex_compose.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonClient {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonResponseDto>
}