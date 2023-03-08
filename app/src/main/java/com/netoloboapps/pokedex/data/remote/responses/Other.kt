package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Other(
    @Json(name = "dream_world")
    val dreamWorld: DreamWorld = DreamWorld(),
    @Json(name = "home")
    val home: Home = Home(),
    @Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork = OfficialArtwork()
)