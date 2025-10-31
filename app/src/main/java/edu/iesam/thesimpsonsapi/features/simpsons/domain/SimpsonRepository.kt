package edu.iesam.thesimpsonsapi.features.simpsons.domain

interface SimpsonRepository {
    suspend fun findAll(page: Int): Result<List<Character>>
}