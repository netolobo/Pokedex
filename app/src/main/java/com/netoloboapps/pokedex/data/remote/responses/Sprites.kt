package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sprites(
    @Json(name = "back_default")
    val backDefault: String = "",
    @Json(name = "back_female")
    val backFemale: Any? = Any(),
    @Json(name = "back_shiny")
    val backShiny: String = "",
    @Json(name = "back_shiny_female")
    val backShinyFemale: Any? = Any(),
    @Json(name = "front_default")
    val frontDefault: String = "",
    @Json(name = "front_female")
    val frontFemale: Any? = Any(),
    @Json(name = "front_shiny")
    val frontShiny: String = "",
    @Json(name = "front_shiny_female")
    val frontShinyFemale: Any? = Any(),
    @Json(name = "other")
    val other: Other = Other(),
    @Json(name = "versions")
    val versions: Versions = Versions()
)