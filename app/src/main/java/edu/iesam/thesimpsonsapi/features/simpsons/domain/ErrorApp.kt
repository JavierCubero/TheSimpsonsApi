package edu.iesam.thesimpsonsapi.features.simpsons.domain

sealed class ErrorApp : Throwable() {
    object ServerError : ErrorApp()
}