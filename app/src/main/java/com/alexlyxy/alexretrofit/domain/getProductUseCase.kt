package com.alexlyxy.alexretrofit.domain

import android.util.Log
import com.alexlyxy.alexretrofit.data.RepositoryImpl
import com.alexlyxy.alexretrofit.domain.Product
import retrofit2.http.GET
import retrofit2.http.Path

//interface ProductApi {
//    @GET("products/{id}")
//    suspend fun getProductById(@Path("id") id: Int): Product
//}


//class GetProductUseCase (private val repository: Repository) {

class GetProductUseCase(private val repository: Repository) {

    suspend fun getProductById(id: Int) {
       val product =  repository.getProductById(id)
        Log.d("MyLog", "Product: $product")
    }
}
