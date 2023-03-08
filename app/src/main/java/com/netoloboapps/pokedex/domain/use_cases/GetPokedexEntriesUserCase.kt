package com.netoloboapps.pokedex.domain.use_cases

import com.netoloboapps.pokedex.domain.PokemonRepository
import com.netoloboapps.pokedex.data.remote.responses.PokemonList
import com.netoloboapps.pokedex.util.Constants
import com.netoloboapps.pokedex.util.Resource
import javax.inject.Inject

class GetPokedexEntriesUserCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(curPage: Int): Resource<PokemonList> =
        repository.getPokemonList(Constants.PAGE_SIZE, curPage * Constants.PAGE_SIZE)
}
