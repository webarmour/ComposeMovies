package ru.webarmour.composemovies.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.webarmour.composemovies.data.models.MoviesDto


interface ApiService {

    @GET("/shows")
    suspend fun getAllMovies() : Response<List<MoviesDto>>

}