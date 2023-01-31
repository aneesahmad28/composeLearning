package com.example.composelearning.network

import com.example.composelearning.data.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var apiService : APIService? = null
    fun getInstance() : APIService {
        if (apiService == null)
        {
            apiService = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(APIService::class.java)
        }
        return apiService!!
    }
}