package edu.iesam.thesimpsonsapi.features.simpsons.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonsApiService {

    @GET("characters")
    suspend fun findAll(@Query("page")page: Int): Response<SimpsonApiModel>
}
