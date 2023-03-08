package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Type(
    @Json(name = "slot")
    val slot: Int = 0,
    @Json(name = "type")
    val type: TypeX = TypeX()
)