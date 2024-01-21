package com.alexlyxy.alexretrofit.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexlyxy.alexretrofit.data.RepositoryImpl
import com.alexlyxy.alexretrofit.domain.GetProductUseCase



class MainViewModel : ViewModel() {

    private val repositoryView = RepositoryImpl

    private val getProductUseCase = GetProductUseCase(repositoryView)

    val product = getProductUseCase.getProductById(id = 3)

    val liveDataList = MutableLiveData<List<TroikaModel>>()
}

