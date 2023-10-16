package com.alexlyxy.alexretrofit.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApi {
    @GET("random{message}{status}")
    suspend fun getDog(@Path("message") message: String, @Path("status")status: String): Dogs
    //suspend fun getProductById(@Path("id") id: Int): Product
}