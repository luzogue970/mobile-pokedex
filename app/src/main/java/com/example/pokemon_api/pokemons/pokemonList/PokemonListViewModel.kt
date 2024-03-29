package com.example.pokemon_api.pokemons.pokemonList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon_api.data.PokemonRepository
import com.example.pokemon_api.data.api.Pokemon
import kotlinx.coroutines.launch

sealed class PokemonListRequestState {
    data object Loading : PokemonListRequestState()
    class Error(val t: Throwable) : PokemonListRequestState()
    class Success(val data: List<Pokemon>) : PokemonListRequestState()
}

class PokemonListViewModel : ViewModel() {
    private val repository = PokemonRepository()
    val pokemonList =
        mutableStateOf<PokemonListRequestState>(PokemonListRequestState.Success(emptyList()))

    fun takePokemons() {
        viewModelScope.launch {
            pokemonList.value = PokemonListRequestState.Loading
            try {
//                val query = searchField.value
                val result = repository.getPokemons()
                pokemonList.value = PokemonListRequestState.Success(result)
            } catch (t: Throwable) {
                pokemonList.value = PokemonListRequestState.Error(t)
            }
        }
    }
}