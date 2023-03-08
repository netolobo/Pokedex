package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FireredLeafgreen(
    @Json(name = "back_default")
    val backDefault: Any? = null,
    @Json(name = "back_shiny")
    val backShiny: Any? = null,
    @Json(name = "front_default")
    val frontDefault: Any? = null,
    @Json(name = "front_shiny")
    val frontShiny: Any? = null
)