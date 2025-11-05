package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character

fun CharactersApiModel.toModel(): Character {
    val imageUrl = "https://cdn.thesimpsonsapi.com/500${this.urlImage}"
    return Character(this.id,
        this.name,
        this.age,
        this.occupation,
        this.status,
        phrase = this.phrases.randomOrNull() ?: "",
        imageUrl)
}