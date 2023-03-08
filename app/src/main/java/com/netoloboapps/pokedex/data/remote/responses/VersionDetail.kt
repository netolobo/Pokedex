package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VersionDetail(
    @Json(name = "rarity")
    val rarity: Int = 0,
    @Json(name = "version")
    val version: Version = Version()
)