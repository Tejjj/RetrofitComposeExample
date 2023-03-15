package com.example.retrofitcomposeexample.repository

import com.example.retrofitcomposeexample.data.UserInfo


interface Repository {
    suspend fun fetchUserList(): List<UserInfo>
}