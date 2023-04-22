package com.netoloboapps.pokedex.util

import com.netoloboapps.pokedex.domain.model.PokedexListEntry

object Constants {

    const val BASE_URL = "https://pokeapi.co/api/v2/"
    const val PAGE_SIZE = 20

    val POKEDEX_ENTRIES_MOCK = listOf(
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
        PokedexListEntry(
            pokemonName = "Blastoise",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            9
        ),
    )
}