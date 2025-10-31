package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

data class SimpsonApiModel(
    val pages :Int,
    val results: List<CharactersApiModel>
)
