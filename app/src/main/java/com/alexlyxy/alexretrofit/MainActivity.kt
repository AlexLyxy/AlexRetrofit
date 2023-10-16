package com.alexlyxy.alexretrofit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alexlyxy.alexretrofit.R.id.tvSuccess
import com.alexlyxy.alexretrofit.retrofit.CoinApi
import com.alexlyxy.alexretrofit.retrofit.DogsAllApi
import com.alexlyxy.alexretrofit.retrofit.DogsApi
import com.alexlyxy.alexretrofit.retrofit.ProductApi
import com.alexlyxy.alexretrofit.retrofit.WeatherApi
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        val tvSuccess = findViewById<TextView>(R.id.tvSuccess)
        val b = findViewById<Button>(R.id.button)

        val ivDogOne = findViewById<ImageView>(R.id.ivDogOne)
        val ivDogTwo = findViewById<ImageView>(R.id.ivDogTwo)
        val ivDogThree = findViewById<ImageView>(R.id.ivDogThree)
        val ivDogFour = findViewById<ImageView>(R.id.ivDogFour)
        val ivDogFive = findViewById<ImageView>(R.id.ivDogFive)


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofitProduct = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productApi = retrofitProduct.create(ProductApi::class.java)

        val retrofitDogs = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val dogsApi = retrofitDogs.create(DogsApi::class.java)

        val retrofitDogsAll = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/hound/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val dogsAllApi = retrofitDogsAll.create(DogsAllApi::class.java)


        val retrofitCoin = Retrofit.Builder()
            .baseUrl("https://min-api.cryptocompare.com/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val coinApi = retrofitCoin.create(CoinApi::class.java)


        val retrofitWeather = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/forecast.json/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val weatherApi = retrofitWeather.create(WeatherApi::class.java)
        Log.d("MyLog", "WeatherApi : $weatherApi")


        b.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {

                val product = productApi.getProductById(3)

                val dogs = dogsApi.getDog(
                    message = "",
                    status = ""
                )

                val dogsAll = dogsAllApi.getDogAll(message = "")
                val dogIndex = dogsAll.message[0]

                val coin = coinApi.getCoin()
                val coinName0 = coin.data[0].coinInfo.fullName
                val coinName1 = coin.data[1].coinInfo.fullName

                val weather = weatherApi.getWeather()
                val forecastdayOne = weather.forecast.forecastday[2]


                runOnUiThread {

                    tv.text = product.title

                    tvSuccess.text = dogs.message
                    tvSuccess.text = dogs.status

                    Picasso.get().load("" + dogsAll.message[0]).into(ivDogOne)
                    Picasso.get().load("" + dogsAll.message[1]).into(ivDogTwo)
                    Picasso.get().load("" + dogsAll.message[2]).into(ivDogThree)
                    Picasso.get().load("" + dogsAll.message[3]).into(ivDogFour)
                    Picasso.get().load("" + dogsAll.message[4]).into(ivDogFive)

                    tvSuccess.text = coin.data[0].coinInfo.fullName
                    tvSuccess.text = coin.data[1].coinInfo.fullName

                    tvSuccess.text = weather.forecast.forecastday[2].date

                    Log.d("MyLog", " Products: $product")
                    Log.d("MyLog", "Dogs : $dogs")
                    Log.d("MyLog", "DogsAll : $dogsAll")
                    Log.d("MyLog", " DogsAllList[0]: $dogIndex")
                    Log.d("MyLog", " Coin: $coin")
                    Log.d("MyLog", " FullName[0]: $coinName0")
                    Log.d("MyLog", "FullName[1] : $coinName1")
                    Log.d("MyLog", "Forecastday : $forecastdayOne")
                    Log.d("MyLog", "Weather : $weather")
                }
            }
        }
    }
}