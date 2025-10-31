package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

import edu.iesam.thesimpsonsapi.core.api.ApiClient
import edu.iesam.thesimpsonsapi.features.simpsons.domain.Character
import edu.iesam.thesimpsonsapi.features.simpsons.domain.ErrorApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimpsonsApiRemoteDataSource(private val apiClient: ApiClient) {

    suspend fun getCharacters(page: Int): Result<List<Character>> {
        return withContext(Dispatchers.IO) {
           val apiService = apiClient.createService(SimpsonsApiService::class.java)
           val resultSimpsons = apiService.findAll(page)
            if (resultSimpsons.isSuccessful &&resultSimpsons.errorBody() == null) {
                val simpsonsApiModel : SimpsonApiModel =  resultSimpsons.body()!!
                val listCharacterApiModel : List<CharactersApiModel> = simpsonsApiModel.results
                val listCharacter = listCharacterApiModel.map { charactersApiModel ->
                    charactersApiModel.toModel()
                }
                Result.success(listCharacter)
            } else {
                Result.failure(ErrorApp.ServerError)
            }
        }
    }
}