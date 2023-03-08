package com.netoloboapps.pokedex.data.remote.responses


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Versions(
    @Json(name = "generation-i")
    val generationI: GenerationI = GenerationI(),
    @Json(name = "generation-ii")
    val generationIi: GenerationIi = GenerationIi(),
    @Json(name = "generation-iii")
    val generationIii: GenerationIii = GenerationIii(),
    @Json(name = "generation-iv")
    val generationIv: GenerationIv = GenerationIv(),
    @Json(name = "generation-v")
    val generationV: GenerationV = GenerationV(),
    @Json(name = "generation-vi")
    val generationVi: GenerationVi = GenerationVi(),
    @Json(name = "generation-vii")
    val generationVii: GenerationVii = GenerationVii(),
    @Json(name = "generation-viii")
    val generationViii: GenerationViii = GenerationViii()
)