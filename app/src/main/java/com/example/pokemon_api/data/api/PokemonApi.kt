package com.example.pokemon_api.data.api

import com.google.gson.annotations.SerializedName

//data class Pokemons(
//    val pokemons: List<Pokemon>
//)
data class Pokemon(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val stats: Stats = Stats(),
    @SerializedName("apiTypes")
    val types: List<Type>
)

data class Stats(
    @SerializedName("HP")
    val hp: Int = 0,
    val attack: Int = 0,
    val defence: Int = 0,
    @SerializedName("special_attack")
    val specialAttack: Int = 0,
    @SerializedName("special_defense")
    val specialDefense: Int = 0,
    val speed: Int = 0
)

data class Type(
    val name: String = "",
    val image: String = ""
)

//data class FeatureResponse(
//    val geometry: GeometryResponse,
//    val properties: PropertiesResponse
//)
//
//data class GeometryResponse(
//    val coordinates: List<Float>
//)
//
//data class PropertiesResponse(
//    @SerializedName("housenumber")
//    val houseNumber: String?,
//    val street: String?,
//    val city: String?,
//    val name: String?,
//    @SerializedName("countrycode")
//    val countryCode: String,
//    val postcode: String?
//)