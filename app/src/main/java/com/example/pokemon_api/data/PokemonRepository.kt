package com.example.pokemon_api.data

import com.example.pokemon_api.data.api.ApiDataSource
import com.example.pokemon_api.data.api.Pokemon

class PokemonRepository {
    private val apiDataSource = ApiDataSource()

    suspend fun getPokemons(): List<Pokemon> {
        return apiDataSource.getAllPokemons()
    }

    suspend fun getPokemonById(id: Int): Pokemon {
        return apiDataSource.getPokemonById(id)
    }
}