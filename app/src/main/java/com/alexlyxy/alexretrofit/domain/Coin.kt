package com.alexlyxy.alexretrofit.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("Data")
    @Expose
    val data: List<Datum>
)

data class Datum(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo
)

data class CoinInfo(
    @SerializedName("Id")
    @Expose
    val id: String,

    @SerializedName("Name")
    @Expose
    val name: String,

    @SerializedName("FullName")
    @Expose
    val fullName: String
)