package edu.iesam.thesimpsonsapi.features.simpsons.domain

class GetAllCharactersUseCase(private val repository: SimpsonRepository) {
    suspend operator fun invoke(): Result<List<Character>> {
        return repository.findAll()
    }
}