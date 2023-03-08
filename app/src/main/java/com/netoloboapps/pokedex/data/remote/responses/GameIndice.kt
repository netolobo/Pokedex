package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameIndice(
    @Json(name = "game_index")
    val gameIndex: Int = 0,
    @Json(name = "version")
    val version: Version = Version()
)