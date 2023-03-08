package com.netoloboapps.pokedex.domain

import com.netoloboapps.pokedex.data.remote.responses.Pokemon
import com.netoloboapps.pokedex.data.remote.responses.PokemonList
import com.netoloboapps.pokedex.util.Resource


interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>
}