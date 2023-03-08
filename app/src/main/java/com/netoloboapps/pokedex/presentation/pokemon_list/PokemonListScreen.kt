package com.netoloboapps.pokedex.presentation.pokemon_list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.netoloboapps.pokedex.R
import com.netoloboapps.pokedex.data.remote.responses.PokemonList
import com.netoloboapps.pokedex.domain.model.PokedexListEntry
import com.netoloboapps.pokedex.util.Constants.POKEDEX_ENTRIES_MOCK
import com.netoloboapps.pokedex.util.DominantColor
import com.netoloboapps.pokedex.presentation.pokemon_list.components.RetrySection
import com.netoloboapps.pokedex.presentation.pokemon_list.components.SearchBar
import com.netoloboapps.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonListScreen(
    state: PokemonListScreenState,
    onItemClick: (dominantColor: Color, pokemonName: String) -> Unit,
    onSearch: (pokemonName: String) -> Unit,
    onLoadPokemonPaginated: () -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                onSearch(it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            PokemonList(
                state = state,
                onItemClick = { dominantColor: Color, pokemonName: String ->
                    onItemClick(
                        dominantColor,
                        pokemonName
                    )
                }
            ) { onLoadPokemonPaginated() }
        }
    }
}

@Composable
fun PokemonList(
    state: PokemonListScreenState,
    onItemClick: (dominantColor: Color, pokemonName: String) -> Unit,
    onLoadPokemonPaginated: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        val itemCount = if (state.pokemonList.size % 2 == 0) {
            state.pokemonList.size
        } else {
            state.pokemonList.size + 1
        }
        items(state.pokemonList.size) { item ->
            if (item >= itemCount - 1 && !state.endReached && !state.isLoading && !state.isSearching) {
                LaunchedEffect(key1 = true) {
                    onLoadPokemonPaginated()
                }
            }
            PokedexEntry(
                entry = state.pokemonList[item],
                onItemClick = { dominantColor, pokemonName ->
                    onItemClick(
                        dominantColor,
                        pokemonName
                    )
                }
            )
        }
    }
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        if (state.loadError.isNotEmpty()) {
            RetrySection(error = state.loadError) {
                onLoadPokemonPaginated()
            }
        }
    }
}

@Composable
fun PokedexEntry(
    entry: PokedexListEntry,
    modifier: Modifier = Modifier,
    onItemClick: (dominantColor: Color, pokemonName: String) -> Unit
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(40.dp))
            .clip(RoundedCornerShape(40.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                onItemClick(
                    dominantColor,
                    entry.pokemonName
                )
            }
    ) {
        Column {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(entry.imageUrl)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                },
                onSuccess = { success ->
                    val drawable = success.result.drawable
                    DominantColor().calcDominantColor(drawable) { color ->
                        dominantColor = color
                    }
                },

                contentDescription = entry.pokemonName,
                modifier = Modifier
                    .size(120.dp)
                    .align(CenterHorizontally)
            )
            Text(
                text = entry.pokemonName,
                fontSize = 20.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }


    }
}


@Preview(showBackground = true)
@Composable
fun PokedexEntryPreview() {
    PokedexTheme {
        PokedexEntry(
            entry = POKEDEX_ENTRIES_MOCK[0],
            onItemClick = { _, _ -> })
    }
}


@Preview(widthDp = 360, heightDp = 640, showBackground = true, backgroundColor = 0xFFC22E28)
@Composable
fun PokemonListScreenPreview() {
    PokedexTheme {
        PokemonListScreen(
            state = PokemonListScreenState(
                pokemonList = POKEDEX_ENTRIES_MOCK
            ),
            onItemClick = { _, _ -> },
            onLoadPokemonPaginated = {},
            onSearch = {}
        )
    }
}