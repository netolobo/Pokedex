package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfficialArtwork(
    @Json(name = "front_default")
    val frontDefault: String = "",
    @Json(name = "front_shiny")
    val frontShiny: String = ""
)