package com.alexlyxy.alexretrofit.domain

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("https://api.weatherapi.com/v1/forecast.json")
    suspend fun getWeather(
        @Query(QUERY_PARAM_API_KEY) key: String =
            "8ea82f6e78674e4996e181556230908",
        @Query(QUERY_PARAM_CITY) q: String = "London",
        @Query(QUERY_PARAM_DAYS) days: Int = 3,
        @Query(QUERY_PARAM_AQI) aqi: String = "no",
        @Query(QUERY_PARAM_ALERTS) alerts: String = "no"

    ): Weather

    companion object {
        private const val QUERY_PARAM_API_KEY = "key"
        private const val QUERY_PARAM_CITY = "q"
        private const val QUERY_PARAM_DAYS = "days"
        private const val QUERY_PARAM_AQI = "aqi"
        private const val QUERY_PARAM_ALERTS = "alerts"

    }
}
/*"https://api.weatherapi.com/v1/forecast.json?key=" +
API_KEY +
"&q=" + "city" +
"&days=" +"3" +
"&aqi=no
&alerts=no"

https://api.weatherapi.com/v1/forecast.json?key=8ea82f6e78674e4996e181556230908&q=London&days=3&aqi=no&alerts=no  */