package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenerationI(
    @Json(name = "red-blue")
    val redBlue: RedBlue = RedBlue(),
    @Json(name = "yellow")
    val yellow: Yellow = Yellow()
)