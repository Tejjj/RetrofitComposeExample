package com.example.retrofitcomposeexample.network

import com.example.retrofitcomposeexample.data.UserInfo
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("comments/")
    suspend fun getUserData(): Response<List<UserInfo>>

}

object UserApi {
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}