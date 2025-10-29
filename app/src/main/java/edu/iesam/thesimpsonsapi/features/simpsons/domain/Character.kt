package edu.iesam.thesimpsonsapi.features.simpsons.domain

data class Character(
    val id: Int,
    val name: String,
    val age: Int,
    val occupation: String,
    val status: String,
    val phrase: String,
    val urlImage: String
)
