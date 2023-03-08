package com.netoloboapps.pokedex.presentation.pokemon_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.netoloboapps.pokedex.ui.theme.PokedexTheme

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = error,
            color = Color.Red,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onRetry() },
        ) {
            Text(text = "Retry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RetrySectionPreview() {
    PokedexTheme {
        RetrySection(error = "Retry section preview") {

        }
    }
}