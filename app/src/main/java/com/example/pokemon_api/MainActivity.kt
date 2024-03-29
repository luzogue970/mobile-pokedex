package com.example.pokemon_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemon_api.pokemons.pokemon.PokemonSingle
import com.example.pokemon_api.pokemons.pokemon.PokemonSingleViewModel
import com.example.pokemon_api.pokemons.pokemonList.PokemonList
import com.example.pokemon_api.pokemons.pokemonList.PokemonListViewModel
import com.example.pokemon_api.ui.theme.PokemonapiTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pokemonListViewModel = PokemonListViewModel()
        val pokemonSingleViewModel = PokemonSingleViewModel()
        setContent {
            PokemonapiTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "pokemon/list") {
                    composable("pokemon/list") {
                        PokemonList(pokemonListViewModel, navController)
                    }
                    composable("pokemon/favorites") {
                        PokemonList(pokemonListViewModel, navController)
                    }
                    composable("pokemon/{pokemonId}") { backStackEntry ->
                        val pokemonId = backStackEntry.arguments!!.getString("pokemonId")!!.toInt()
                        PokemonSingle(pokemonId, pokemonSingleViewModel, navController)
                    }
                }
            }
        }
    }
}