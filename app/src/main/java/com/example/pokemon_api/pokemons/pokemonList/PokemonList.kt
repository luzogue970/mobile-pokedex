package com.example.pokemon_api.pokemons.pokemonList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokemon_api.R

@Composable
fun PokemonList(
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
        Column {
            OutlinedTextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                label = { Text(stringResource(id = R.string.search)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

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
                        text = "pokemon list loading"
                    )
                }
            }
        }
    }
}