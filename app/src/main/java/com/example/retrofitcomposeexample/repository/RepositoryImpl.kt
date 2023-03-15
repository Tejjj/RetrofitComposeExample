package com.example.retrofitcomposeexample.repository

import com.example.retrofitcomposeexample.data.UserInfo


class RepositoryImpl : Repository {

    override suspend fun fetchUserList(): List<UserInfo> {
        var userList: List<UserInfo> = RemoteDataSource().fetchUserList()
        if (userList == null || userList.isEmpty()) {
            userList = LocalDataSource().fetchUserList()
        }
        return userList
    }
}