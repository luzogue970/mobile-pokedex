package com.example.pokemon_api.pokemons.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokemon_api.R

@Composable
fun PokemonSingle(
    pokemonId: Int,
    viewModel: PokemonSingleViewModel,
    navController: NavHostController
) {
    val pokemonSingle = remember {
        viewModel.pokemon
    }
    LaunchedEffect(key1 = null) {
        viewModel.takePokemonById(pokemonId)
    }
    val titleSize: TextUnit = 20.sp
    val medTitleSize: TextUnit = 15.sp
    val bodySize: TextUnit = 10.sp

    when (val pokemonSingleValue = pokemonSingle.value) {
        is PokemonSingleRequestState.Success -> {
            Surface(Modifier.fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor("#755C1B")
                            ), Color.White
                        ),
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(text = "retourner à la liste", fontSize = medTitleSize)
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth(0.9F)
                            .background(Color(android.graphics.Color.parseColor("#D7BE82")))
                            .padding(10.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Text(
                            text = pokemonSingleValue.data.name,
                            textAlign = TextAlign.Center,
                            fontSize = titleSize
                        )
                        AsyncImage(
                            model = pokemonSingleValue.data.image,
                            contentDescription = pokemonSingleValue.data.name,
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Column(horizontalAlignment = Alignment.Start) {
                            Text(
                                stringResource(id = R.string.pokemonType) + ":",
                                fontSize = medTitleSize,
                                modifier = Modifier.padding(3.dp)
                            )
                            LazyRow(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                items(pokemonSingleValue.data.types) { type ->
                                    TypeItem(type)
                                }
                            }
                            Text(text = "stats", fontSize = medTitleSize)
                            Column(
                                Modifier
                                    .padding(1.dp)
                                    .background(Color(android.graphics.Color.parseColor("#755C1B")))
                                    .padding(10.dp)
                            ) {
                                Text("HP: " + pokemonSingleValue.data.stats.hp, fontSize = bodySize)
                                Text(
                                    stringResource(id = R.string.pokemonAttack) + ": " + pokemonSingleValue.data.stats.attack,
                                    fontSize = bodySize
                                )
                                Text(
                                    stringResource(id = R.string.pokemonDefence) + ": " + pokemonSingleValue.data.stats.defence,
                                    fontSize = bodySize
                                )
                                Text(
                                    stringResource(id = R.string.PokemonSpecialAttack) + ": " + pokemonSingleValue.data.stats.specialAttack,
                                    fontSize = bodySize
                                )
                                Text(
                                    stringResource(id = R.string.pokemonSpecialDefence) + ": " + pokemonSingleValue.data.stats.specialDefense,
                                    fontSize = bodySize
                                )
                                Text(
                                    stringResource(id = R.string.pokemonSpeed) + ": " + pokemonSingleValue.data.stats.speed,
                                    fontSize = bodySize
                                )
                            }
                        }
                    }
                }

//                    PokemonItem(pokemonSingleValue.data, navController)
            }
        }

        else -> {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "pokemon loading"
            )
        }
    }
//    }

//        Column(
//                Modifier
//                    .fillMaxWidth(),
//                verticalArrangement = Arrangement.SpaceAround,
//                horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(text = "test")
////                AsyncImage(
////                    model = pokemon.image,
////                    contentDescription = pokemon.name,
////                    modifier = Modifier.size(100.dp)
////                )
////                Text(text = pokemon.name, color = Color.Black)
//        }
}