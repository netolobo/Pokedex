package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiamondPearl(
    @Json(name = "back_default")
    val backDefault: String = "",
    @Json(name = "back_female")
    val backFemale: Any? = null,
    @Json(name = "back_shiny")
    val backShiny: String = "",
    @Json(name = "back_shiny_female")
    val backShinyFemale: Any? = null,
    @Json(name = "front_default")
    val frontDefault: String = "",
    @Json(name = "front_female")
    val frontFemale: Any? = null,
    @Json(name = "front_shiny")
    val frontShiny: String = "",
    @Json(name = "front_shiny_female")
    val frontShinyFemale: Any? = null
)