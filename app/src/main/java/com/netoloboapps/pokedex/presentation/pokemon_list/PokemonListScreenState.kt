package com.netoloboapps.pokedex.presentation.pokemon_list

import com.netoloboapps.pokedex.domain.model.PokedexListEntry

data class PokemonListScreenState(
    val pokemonList: List<PokedexListEntry> = listOf(),
    val loadError: String = "",
    val isLoading: Boolean = false,
    val endReached: Boolean = false,
    val isSearching: Boolean = false
)