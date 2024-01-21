package com.alexlyxy.alexretrofit.data

import com.alexlyxy.alexretrofit.domain.Coin
import com.alexlyxy.alexretrofit.domain.Product
import com.alexlyxy.alexretrofit.domain.Repository
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryImpl: Repository {

object RepositoryImpl : Repository {
    //override suspend fun getCoin(apiKey: String, limit: Int, tSym: String): Coin {
    override suspend fun getProduct(product: Product): Product {


        //interface ProductApi {
//    @GET("products/{id}")
//    suspend fun getProductById(@Path("id") id: Int): Product
//}

    }

}
    }


// override suspend fun getCoin(coin: Coin) {
//        @GET("data/top/totalvolfull")
//        suspend fun getCoin(
//            @Query(QUERY_PARAM_API_KEY) apiKey: String =
//                "3b3ba35438659a4323ad8042ca70492a2a9cbc6390e7a07d908aec1989d96b81",
//            @Query(QUERY_PARAM_LIMIT) limit: Int = 2,
//            @Query(QUERY_PARAM_TO_SYMBOL) tSym: String =  CURRENCY
//        ): Coin
//
//        companion object {
//            private const val QUERY_PARAM_API_KEY = "api_key"
//            private const val QUERY_PARAM_LIMIT = "limit"
//            private const val QUERY_PARAM_TO_SYMBOL = "tsym"
//            private const val CURRENCY = "USD"
//        }
