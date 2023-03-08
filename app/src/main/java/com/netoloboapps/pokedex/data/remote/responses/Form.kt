package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Form(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "url")
    val url: String = ""
)