package com.example.pokemon_api.pokemons.fovoris

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokemon_api.pokemons.pokemonList.PokemonItem
import com.example.pokemon_api.pokemons.pokemonList.PokemonListRequestState
import com.example.pokemon_api.pokemons.pokemonList.PokemonListViewModel

@Composable
fun PokemonFavorite(
    viewModel: PokemonListViewModel,
    navController: NavHostController
) {
    val pokemonList = remember {
        viewModel.pokemonList
    }
    val searchText = remember { mutableStateOf("") }
    LaunchedEffect(key1 = null) {
        viewModel.takePokemons()
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        when (val currentPokemonList = pokemonList.value) {
            is PokemonListRequestState.Success -> {
                val filteredList = currentPokemonList.data.filter {
                    it.name.contains(searchText.value, ignoreCase = true)
                }
                if (filteredList.isNotEmpty()) {
                    LazyColumn {
                        items(filteredList) { pokemon ->
                            PokemonItem(pokemon, navController)
                        }
                    }
                } else {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "No matching Pokémon found"
                    )
                }
            }

            else -> {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Pokémon list not available"
                )
            }
        }
    }
}