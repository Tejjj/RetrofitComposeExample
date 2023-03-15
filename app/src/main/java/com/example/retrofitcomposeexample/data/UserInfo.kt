package com.example.retrofitcomposeexample.data

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val id: Int,
    val name: String,
)



object UserNameList {
    val nameList = listOf(
        UserInfo(1, "white"),
        UserInfo(2, "Black"),
        UserInfo(3,"RED"),
        UserInfo(4,"Orange"),
        UserInfo(5,"Yellow"),
        UserInfo(6,"Green"),
        UserInfo(7,"Blue"),
        UserInfo(8,"Indigo"),
        UserInfo(9,"Violet"),
        UserInfo(10,"Pearl"),
        UserInfo(11,"Magenta"),
    )
}
