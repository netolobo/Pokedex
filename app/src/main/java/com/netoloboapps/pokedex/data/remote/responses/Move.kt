package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Move(
    @Json(name = "move")
    val move: MoveX = MoveX(),
    @Json(name = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail> = listOf()
)