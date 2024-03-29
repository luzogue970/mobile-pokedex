package com.example.pokemon_api.pokemons.fovoris

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

class PokemonFavoriteViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val pokemonFavorite =
        mutableStateOf<PokemonListRequestState>(PokemonListRequestState.Success(emptyList()))

    fun takeFavoritePokemons() {
        viewModelScope.launch {
            pokemonFavorite.value = PokemonListRequestState.Loading
            try {
//                val query = searchField.value
                val result = repository.getPokemons()
                pokemonFavorite.value = PokemonListRequestState.Success(result)
            } catch (t: Throwable) {
                pokemonFavorite.value = PokemonListRequestState.Error(t)
            }
        }
    }
}