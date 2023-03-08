package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ability(
    @Json(name = "ability")
    val ability: AbilityX = AbilityX(),
    @Json(name = "is_hidden")
    val isHidden: Boolean = false,
    @Json(name = "slot")
    val slot: Int = 0
)