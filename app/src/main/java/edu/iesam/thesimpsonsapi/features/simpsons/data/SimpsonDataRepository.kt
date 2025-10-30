package edu.iesam.thesimpsonsapi.features.simpsons.data

import edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api.SimpsonsApiRemoteDataSource
import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character
import edu.iesam.thesimpsonsapi.features.simpsons.domain.SimpsonRepository

class SimpsonDataRepository(private val remote: SimpsonsApiRemoteDataSource): SimpsonRepository {
    override suspend fun findAll(): Result<List<Character>> {
        return remote.getCharacters()
    }
}