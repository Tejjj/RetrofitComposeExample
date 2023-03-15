package com.example.retrofitcomposeexample.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcomposeexample.data.UserInfo
import com.example.retrofitcomposeexample.repository.RepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class UiState {
    data class Success(val userList: List<UserInfo>) : UiState()
    data class Error(val errorMsg: String) : UiState()
    object Loading : UiState()
}

class UserViewModel : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        fetchUserList()
    }

    private fun fetchUserList() {
        viewModelScope.launch {
            uiState = try {
                val userListResult = RepositoryImpl().fetchUserList()
                UiState.Success(userListResult)
            } catch (ioException: IOException) {
                UiState.Error("Problem with Network Connection, \n Please make sure you have stable internet connection in your device.")
            } catch (httpException: HttpException) {
                UiState.Error("Unable to connect to network, \n Please try after sometime.")
            }
        }
    }

}