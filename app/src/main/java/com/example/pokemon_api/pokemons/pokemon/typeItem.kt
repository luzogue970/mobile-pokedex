package com.example.pokemon_api.pokemons.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemon_api.data.api.Type
import typeColor

@Composable
fun TypeItem(
    type: Type,
) {
    val typeColor: Color = typeColor(type.name)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .background(
                color = typeColor,
                shape = CircleShape
            )
            .padding(5.dp)
    ) {
        Text(text = type.name, fontSize = 10.sp, modifier = Modifier.padding(2.dp))
        AsyncImage(
            model = type.image,
            contentDescription = type.name,
            modifier = Modifier
                .size(35.dp)
                .padding(2.dp)
        )
    }

}