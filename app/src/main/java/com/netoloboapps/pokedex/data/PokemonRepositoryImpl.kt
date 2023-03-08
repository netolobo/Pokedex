package com.netoloboapps.pokedex.data

import com.netoloboapps.pokedex.data.remote.PokeApi
import com.netoloboapps.pokedex.data.remote.responses.Pokemon
import com.netoloboapps.pokedex.data.remote.responses.PokemonList
import com.netoloboapps.pokedex.domain.PokemonRepository
import com.netoloboapps.pokedex.util.Resource
import javax.inject.Inject


class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi,
) : PokemonRepository{


    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error("Error = ${e.message}")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("Error = ${e.message}")
        }
        return Resource.Success(response)
    }
}