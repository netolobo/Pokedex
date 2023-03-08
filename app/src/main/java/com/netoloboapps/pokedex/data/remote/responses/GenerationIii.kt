package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenerationIii(
    @Json(name = "emerald")
    val emerald: Emerald = Emerald(),
    @Json(name = "firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen = FireredLeafgreen(),
    @Json(name = "ruby-sapphire")
    val rubySapphire: RubySapphire = RubySapphire()
)