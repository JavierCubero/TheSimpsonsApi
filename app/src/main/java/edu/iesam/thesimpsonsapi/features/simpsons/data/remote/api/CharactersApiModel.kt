package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

import com.google.gson.annotations.SerializedName

data class CharactersApiModel(
    val id: Int,
    val name: String,
    val age: String?,
    val occupation: String,
    val status: String,
    val phrases: List<String>,
    @SerializedName("portrait_path") val urlImage: String
)
