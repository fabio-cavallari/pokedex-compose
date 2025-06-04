package com.example.pokedex_compose.data

import android.util.Log
import com.example.pokedex_compose.domain.Pokemon
import com.example.pokedex_compose.domain.Type
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
            Log.e(">>>", e.message.toString())
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(url: String) : Result<List<Type>> {
        return try {
            val response = pokemonRemoteProvider.getPokemonDetail(url)
            if (response.isSuccessful && response.body() != null) {
                val pokemonDetailDto = response.body()
                val typeList = pokemonDetailDto!!.types.map { typeSlot ->
                    Type(typeSlot.type.name, typeSlot.type.url)
                }
                Result.success(typeList)
            } else {
                Result.failure(Exception("request error"))
            }
        } catch (e: Exception) {
            Log.e(">>>", e.message.toString())
            Result.failure(e)
        }
    }
}