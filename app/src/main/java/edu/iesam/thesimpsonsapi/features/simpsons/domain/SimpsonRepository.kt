package edu.iesam.thesimpsonsapi.features.simpsons.domain

interface SimpsonRepository {
    suspend fun findAll(): Result<List<Character>>
}