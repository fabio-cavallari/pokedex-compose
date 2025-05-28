package com.example.pokedex_compose.data

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object NetworkHelper {
    private val pokemonBaseUrl = "https://pokeapi.co/api/v2/"

    private val okHttpClient = OkHttpClient
        .Builder()
        .build()

    private val objectMapper = ObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun <T> buildRetrofitClient(client: Class<T>): T{
        return Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .baseUrl(pokemonBaseUrl)
            .client(okHttpClient)
            .build()
            .create(client)
    }
}