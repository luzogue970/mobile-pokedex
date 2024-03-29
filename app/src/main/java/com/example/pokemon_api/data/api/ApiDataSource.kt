package com.example.pokemon_api.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiDataSource {
    private val pokemonApiService = Retrofit.Builder()
        .baseUrl("https://pokebuildapi.fr/api/v1/")
        .addConverterFactory(GsonConverterFactory.create()) // Va faire le parsing
        .build()
        .create(PokemonApiService::class.java)

    suspend fun getAllPokemons() =
        pokemonApiService.getPokemons()

    suspend fun getPokemonById(id: Int) =
        pokemonApiService.getPokemonById(id)
}