package com.example.composelearning.network

import com.example.composelearning.data.BASE_URL
import com.example.composelearning.data.ToDo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {

    @GET("todos")
    suspend fun getTodos(): List<ToDo>


}