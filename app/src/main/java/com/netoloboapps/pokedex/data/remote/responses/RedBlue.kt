package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RedBlue(
    @Json(name = "back_default")
    val backDefault: Any? = null,
    @Json(name = "back_gray")
    val backGray: Any? = null,
    @Json(name = "back_transparent")
    val backTransparent: Any? = null,
    @Json(name = "front_default")
    val frontDefault: Any? = null,
    @Json(name = "front_gray")
    val frontGray: Any? = null,
    @Json(name = "front_transparent")
    val frontTransparent: Any? = null
)