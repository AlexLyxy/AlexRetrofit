package com.alexlyxy.alexretrofit.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface DogsAllApi {
    @GET("images{message}")
    suspend fun getDogAll(@Path("message") message: String): DogsAll
}