package com.alexlyxy.alexretrofit.domain

import com.alexlyxy.alexretrofit.domain.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}
