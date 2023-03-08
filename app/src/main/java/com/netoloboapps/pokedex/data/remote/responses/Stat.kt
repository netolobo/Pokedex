package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stat(
    @Json(name = "base_stat")
    val baseStat: Int = 0,
    @Json(name = "effort")
    val effort: Int = 0,
    @Json(name = "stat")
    val stat: StatX = StatX()
)