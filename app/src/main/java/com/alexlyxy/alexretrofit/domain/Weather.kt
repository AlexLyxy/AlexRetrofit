package com.alexlyxy.alexretrofit.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("forecast")
    @Expose
    val forecast: Forecast
)

data class Forecast(
    @SerializedName("forecastday")
    @Expose
    val forecastday: List<Forecastday>
)

data class Forecastday(
    @SerializedName("date")
    @Expose
    val date: String

)
