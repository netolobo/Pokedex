package com.netoloboapps.pokedex.domain.use_cases

import com.netoloboapps.pokedex.domain.PokemonRepository
import com.netoloboapps.pokedex.data.remote.responses.Pokemon
import com.netoloboapps.pokedex.util.Resource
import javax.inject.Inject

class GetPokemonInfoUserCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(pokemonName: String): Resource<Pokemon> =
        repository.getPokemonInfo(pokemonName)
}