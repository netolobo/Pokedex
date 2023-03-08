package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pokemon(
    @Json(name = "abilities")
    val abilities: List<Ability> = listOf(),
    @Json(name = "base_experience")
    val baseExperience: Int = 0,
    @Json(name = "forms")
    val forms: List<Form> = listOf(),
    @Json(name = "game_indices")
    val gameIndices: List<GameIndice> = listOf(),
    @Json(name = "height")
    val height: Int = 0,
    @Json(name = "held_items")
    val heldItems: List<HeldItem> = listOf(),
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "is_default")
    val isDefault: Boolean = false,
    @Json(name = "location_area_encounters")
    val locationAreaEncounters: String = "",
    @Json(name = "moves")
    val moves: List<Move> = listOf(),
    @Json(name = "name")
    val name: String = "",
    @Json(name = "order")
    val order: Int = 0,
    @Json(name = "past_types")
    val pastTypes: List<Any> = listOf(),
    @Json(name = "species")
    val species: Species = Species(),
    @Json(name = "sprites")
    val sprites: Sprites = Sprites(),
    @Json(name = "stats")
    val stats: List<Stat> = listOf(),
    @Json(name = "types")
    val types: List<Type> = listOf(),
    @Json(name = "weight")
    val weight: Int = 0
)