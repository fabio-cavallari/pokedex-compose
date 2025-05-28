package com.example.pokedex_compose.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex_compose.domain.Pokemon

@Composable
fun PokemonCard(pokemon: Pokemon, index: Int, onClick: () -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(width = 1.dp, color = MaterialTheme.colorScheme.onSurface, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.surface,
        )

    ) {
        Row(
            Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .height(100.dp)
                    .width(100.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "pokemonSprite",
                    contentScale = ContentScale.Fit,
                    model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index+1}.png",
                )
            }
            Spacer(Modifier.width(16.dp))
            Text(pokemon.name, fontSize = 24.sp, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}