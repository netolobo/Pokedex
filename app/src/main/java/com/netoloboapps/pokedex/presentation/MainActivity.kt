package com.netoloboapps.pokedex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.netoloboapps.pokedex.data.remote.responses.Pokemon
import com.netoloboapps.pokedex.util.Resource
import com.netoloboapps.pokedex.presentation.pokemon_detail.PokemonDetailScreen
import com.netoloboapps.pokedex.presentation.pokemon_detail.PokemonDetailViewModel
import com.netoloboapps.pokedex.presentation.pokemon_list.PokedexListViewModel
import com.netoloboapps.pokedex.presentation.pokemon_list.PokemonListScreen
import com.netoloboapps.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_nav_screen"
                ) {
                    composable(route = "pokemon_nav_screen") {
                        val viewModel: PokedexListViewModel = hiltViewModel()

                        PokemonListScreen(
                            state = viewModel.state.value,
                            onItemClick = { dominantColor, pokemonName ->

                                navController.navigate(
                                    route = "pokemon_detail_screen/${dominantColor.toArgb()}/${pokemonName}"
                                )
                                viewModel.clearCachedPokemonList()
                            },
                            onSearch = { pokemonName -> viewModel.searchPokemonList(pokemonName) },
                            onLoadPokemonPaginated = { viewModel.loadPokemonPaginated() }
                        )
                    }
                    composable(
                        route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                        val viewModel: PokemonDetailViewModel = hiltViewModel()

                        val pokemonInfo =
                            produceState<Resource<Pokemon>>(initialValue = Resource.Loading()) {
                                value = viewModel.getPokemonInfo(
                                    pokemonName?.lowercase(Locale.ROOT) ?: ""
                                )
                            }.value

                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            onBackClick = { navController.popBackStack() },
                            pokemonInfo = pokemonInfo
                        )
                    }
                }
            }
        }
    }
}
