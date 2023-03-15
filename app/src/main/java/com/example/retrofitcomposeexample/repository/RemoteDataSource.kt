package com.example.retrofitcomposeexample.repository

import com.example.retrofitcomposeexample.data.UserInfo
import com.example.retrofitcomposeexample.network.UserApi


class RemoteDataSource {
    suspend fun fetchUserList(): List<UserInfo> {
        val response = UserApi.apiService.getUserData()
        if(response.isSuccessful) {
            return response.body()!!
        }
        return emptyList()
    }
}