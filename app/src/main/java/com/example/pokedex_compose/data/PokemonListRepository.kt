package com.example.pokedex_compose.data

import android.util.Log
import com.example.pokedex_compose.domain.Pokemon
import com.example.pokedex_compose.domain.asDomainModel

class PokemonListRepository {
    val pokemonRemoteProvider = PokemonRemoteProvider()

    suspend fun getPokemonList(limit: Int, offset: Int) : Result<List<Pokemon>> {
        return try {
            val response = pokemonRemoteProvider.getPokemonList(limit, offset)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!.results.asDomainModel())
            } else {
                Result.failure(Exception("request error"))
            }
        } catch (e: Exception) {
            Log.d(">>>", e.message.toString())
            Result.failure(e)
        }
    }
}