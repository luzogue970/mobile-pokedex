package com.example.pokemon_api.pokemons.pokemon

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon_api.data.PokemonRepository
import com.example.pokemon_api.data.api.Pokemon
import kotlinx.coroutines.launch

sealed class PokemonSingleRequestState {
    data object Loading : PokemonSingleRequestState()
    class Error(val t: Throwable) : PokemonSingleRequestState()
    class Success(val data: Pokemon) : PokemonSingleRequestState()
}

class PokemonSingleViewModel : ViewModel() {
    private val repository = PokemonRepository()
    val pokemon = mutableStateOf<PokemonSingleRequestState>(PokemonSingleRequestState.Loading)

    fun takePokemonById(id: Int) {
        viewModelScope.launch {
            pokemon.value = PokemonSingleRequestState.Loading
            try {
                val result = repository.getPokemonById(id)
                pokemon.value = PokemonSingleRequestState.Success(result)
            } catch (t: Throwable) {
                pokemon.value = PokemonSingleRequestState.Error(t)
            }
        }
    }
}