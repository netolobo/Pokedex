package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Crystal(
    @Json(name = "back_default")
    val backDefault: String = "",
    @Json(name = "back_shiny")
    val backShiny: String = "",
    @Json(name = "back_shiny_transparent")
    val backShinyTransparent: String = "",
    @Json(name = "back_transparent")
    val backTransparent: String = "",
    @Json(name = "front_default")
    val frontDefault: String = "",
    @Json(name = "front_shiny")
    val frontShiny: String = "",
    @Json(name = "front_shiny_transparent")
    val frontShinyTransparent: String = "",
    @Json(name = "front_transparent")
    val frontTransparent: String = ""
)