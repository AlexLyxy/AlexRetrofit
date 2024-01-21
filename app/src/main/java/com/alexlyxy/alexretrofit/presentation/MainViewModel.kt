package com.alexlyxy.alexretrofit.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexlyxy.alexretrofit.data.RepositoryImpl


class MainViewModel : ViewModel() {
    val liveDataList = MutableLiveData<List<TroikaModel>>()
}