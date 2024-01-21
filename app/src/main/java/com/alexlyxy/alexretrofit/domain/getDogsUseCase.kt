package com.alexlyxy.alexretrofit.domain

import com.alexlyxy.alexretrofit.domain.Dogs
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {
    @GET("random{message}{status}")
    suspend fun getDog(@Path("message") message: String, @Path("status")status: String): Dogs
    //suspend fun getProductById(@Path("id") id: Int): Product
}