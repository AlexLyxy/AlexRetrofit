package com.alexlyxy.alexretrofit.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {
    @GET("data/top/totalvolfull")
    suspend fun getCoin(
        @Query(QUERY_PARAM_API_KEY) apiKey: String =
            "3b3ba35438659a4323ad8042ca70492a2a9cbc6390e7a07d908aec1989d96b81",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 2,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String =  CURRENCY
    ): Coin

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"

        private const val CURRENCY = "USD"
    }
}

//https://min-api.cryptocompare.com/data/top/totalvolfull?limit=10&tsym=USD
//?limit=10&tsym=USD