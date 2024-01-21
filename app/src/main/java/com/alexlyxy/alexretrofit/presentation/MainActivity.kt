package com.alexlyxy.alexretrofit.presentation

//import com.alexlyxy.alexretrofit.domain.CoinApi
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexlyxy.alexretrofit.data.RepositoryImpl
import com.alexlyxy.alexretrofit.databinding.ActivityMainBinding
import com.alexlyxy.alexretrofit.domain.GetProductUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TroikaAdapter
    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bGet.setOnClickListener {
            init()
            model.liveDataList.observe(this@MainActivity) {
                adapter.submitList(it)
                Log.d("MyLog", "Size: ${it.size}")
            }
            CoroutineScope(Dispatchers.IO).launch {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                val retrofitProduct = Retrofit.Builder()
                    .baseUrl("https://dummyjson.com").client(client)
                    .addConverterFactory(GsonConverterFactory.create()).build()

                val productApi = retrofitProduct.create(GetProductUseCase::class.java)

//                val retrofitDogs = Retrofit.Builder()
//                    .baseUrl("https://dog.ceo/api/breeds/image/").client(client)
//                    .addConverterFactory(GsonConverterFactory.create()).build()
//
//                val dogsApi = retrofitDogs.create(DogsApi::class.java)
//
//                val retrofitDogsAll = Retrofit.Builder()
//                    .baseUrl("https://dog.ceo/api/breed/hound/").client(client)
//                    .addConverterFactory(GsonConverterFactory.create()).build()
//
//                val dogsAllApi = retrofitDogsAll.create(DogsAllApi::class.java)
//
//                val retrofitCoin = Retrofit.Builder()
//                    .baseUrl("https://min-api.cryptocompare.com/").client(client)
//                    .addConverterFactory(GsonConverterFactory.create()).build()
//
//               val coinApi = retrofitCoin.create(CoinApi::class.java)
//                //val getCoinUseCase = retrofitCoin.create(GetCoinUseCase::class.java)
//
//
//                val retrofitWeather = Retrofit.Builder()
//                    .baseUrl("https://api.weatherapi.com/v1/forecast.json/").client(client)
//                    .addConverterFactory(GsonConverterFactory.create()).build()
//
//                val weatherApi = retrofitWeather.create(WeatherApi::class.java)

                val product = productApi.getProductById(3)

//                val dogs = dogsApi.getDog(
//                    message = "",
//                    status = ""
//                )
//
//                val dogsAll = dogsAllApi.getDogAll(
//                    message = ""
//                )
//
//                val coin = coinApi.getCoin()
//                //val getCoinUseCase= GetCoinUseCase(repository)
//               // val coin = getCoinUseCase.getCoin(repository)
//
//                val weather = weatherApi.getWeather()

                val list = ArrayList<TroikaModel>()
                for (i in 0 until 2) {
                    val item = TroikaModel(
                        product.id,
                        product.title,
                        product.description,
                        product.price
//                        dogs.status,
//                        dogsAll.message[0],
//                        dogsAll.message[1],
//                        dogsAll.message[2],
//                        dogsAll.message[3],
//                        dogsAll.message[4],
//                        coin.data[0].coinInfo.name,
//                        coin.data[0].coinInfo.fullName,
//                        weather.forecast.forecastday[2].date[0].toString(),
//                        weather.forecast.forecastday[2].date[1].toString(),
//                        weather.forecast.forecastday[2].date[2].toString()
                    )
                    list.add(item)
                }

                runOnUiThread {
                    model.liveDataList.value = list

                    Log.d("MyLog", " Products: $product")
//                    Log.d("MyLog", "Dogs : $dogs")
//                    Log.d("MyLog", "DogsAll : $dogsAll")
//                    Log.d("MyLog", " Coin: $coin")
//                    Log.d("MyLog", "Weather : $weather")
                    Log.d("MyLog", "List : $list")
                }
            }
            // After Coroutine
        }
        //After bGet
    }
    //After onCreate

    private fun init() = with(binding) {
        adapter = TroikaAdapter()
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        rcView.adapter = adapter
    }
}