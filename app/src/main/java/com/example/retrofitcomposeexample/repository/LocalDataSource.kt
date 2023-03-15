package com.example.retrofitcomposeexample.repository

import com.example.retrofitcomposeexample.data.UserInfo
import com.example.retrofitcomposeexample.data.UserNameList


class LocalDataSource {
    fun fetchUserList(): List<UserInfo> {
        return UserNameList.nameList
    }
}