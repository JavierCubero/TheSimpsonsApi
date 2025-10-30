package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpsonsApiService {

    @GET("characters")
    suspend fun findAll(): Response<SimpsonApiModel>
}
