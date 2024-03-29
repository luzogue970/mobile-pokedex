package com.example.pokemon_api.pokemons.pokemonList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokemon_api.data.api.Pokemon

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    navController: NavHostController
) {
    Surface {
        Button(
            modifier = Modifier.padding(15.dp),
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(
                    android.graphics.Color.parseColor(
                        "#D7BE82"
                    )
                ), contentColor = Color(android.graphics.Color.parseColor("#515A47"))
            ),
            onClick = { navController.navigate("pokemon/" + pokemon.id) }) {
            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                AsyncImage(
                    model = pokemon.image,
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(100.dp)
                )
                Text(text = pokemon.name, color = Color.Black, fontSize = 15.sp)
            }
        }
    }
}