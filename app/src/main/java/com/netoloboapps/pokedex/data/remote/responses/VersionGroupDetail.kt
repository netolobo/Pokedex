package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VersionGroupDetail(
    @Json(name = "level_learned_at")
    val levelLearnedAt: Int = 0,
    @Json(name = "move_learn_method")
    val moveLearnMethod: MoveLearnMethod = MoveLearnMethod(),
    @Json(name = "version_group")
    val versionGroup: VersionGroup = VersionGroup()
)