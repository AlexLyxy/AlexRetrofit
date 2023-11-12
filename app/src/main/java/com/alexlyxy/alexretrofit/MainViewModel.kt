package com.alexlyxy.alexretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexlyxy.alexretrofit.adapters.TroikaModel

class MainViewModel : ViewModel() {
    val liveDataList = MutableLiveData<List<TroikaModel>>()
}