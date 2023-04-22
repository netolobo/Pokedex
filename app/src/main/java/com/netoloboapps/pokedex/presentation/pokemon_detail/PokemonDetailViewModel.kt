package com.netoloboapps.pokedex.presentation.pokemon_detail

import androidx.lifecycle.ViewModel
import com.netoloboapps.pokedex.data.remote.responses.Pokemon
import com.netoloboapps.pokedex.domain.use_cases.GetPokemonInfoUserCase
import com.netoloboapps.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonInfoUserCase: GetPokemonInfoUserCase
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> =
        getPokemonInfoUserCase(pokemonName)
}