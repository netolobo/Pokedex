package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeldItem(
    @Json(name = "item")
    val item: Item = Item(),
    @Json(name = "version_details")
    val versionDetails: List<VersionDetail> = listOf()
)