package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenerationIv(
    @Json(name = "diamond-pearl")
    val diamondPearl: DiamondPearl = DiamondPearl(),
    @Json(name = "heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver = HeartgoldSoulsilver(),
    @Json(name = "platinum")
    val platinum: Platinum = Platinum()
)