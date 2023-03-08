package com.netoloboapps.pokedex.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netoloboapps.pokedex.domain.model.PokedexListEntry
import com.netoloboapps.pokedex.domain.use_cases.GetPokedexEntriesUserCase
import com.netoloboapps.pokedex.util.Constants.PAGE_SIZE
import com.netoloboapps.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokedexListViewModel @Inject constructor(
    private val getPokedexEntriesUserCase: GetPokedexEntriesUserCase,
) : ViewModel() {

    private val _state = mutableStateOf(
        PokemonListScreenState()
    )
    val state: State<PokemonListScreenState>
        get() = _state

    private var _curPage = 0
    private var _cachedPokemonList = listOf<PokedexListEntry>()
    private var isSearchStarting = true

    init {
        loadPokemonPaginated()
    }

    fun clearCachedPokemonList(){
        if(_cachedPokemonList.isNotEmpty()){
            isSearchStarting = false
        }
    }

    fun searchPokemonList(query: String) {
        val listToSearch = if (isSearchStarting) {
            _state.value.pokemonList
        } else {
            _cachedPokemonList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                _state.value = _state.value.copy(
                    pokemonList = _cachedPokemonList,
                    isSearching = false
                )
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.pokemonName.contains(query.trim(), ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if (isSearchStarting) {

                _cachedPokemonList = _state.value.pokemonList
                isSearchStarting = false
            }

            _state.value = _state.value.copy(
                pokemonList = results,
                isSearching = true
            )
        }
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )
            when (val result = getPokedexEntriesUserCase.invoke(_curPage)) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        endReached = _curPage * PAGE_SIZE >= result.data!!.count
                    )
                    val pokedexEntries = result.data.results.mapIndexed { index, entry ->
                        var number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url =
                            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        PokedexListEntry(entry.name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.ROOT
                            ) else it.toString()
                        }, url, number.toInt())
                    }
                    _curPage++
                    val updatedPokemonList = _state.value.pokemonList.toMutableList()
                    updatedPokemonList += pokedexEntries
                    _state.value = _state.value.copy(
                        loadError = "",
                        isLoading = false,
                        pokemonList = updatedPokemonList
                    )
                }
                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        loadError = result.message!!,
                        isLoading = false
                    )
                }
                else -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
            }
        }
    }
}