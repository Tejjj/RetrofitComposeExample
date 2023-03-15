package com.example.retrofitcomposeexample.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitcomposeexample.R
import com.example.retrofitcomposeexample.ui.viewModel.UserViewModel

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background),
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.user)) },
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.primary, shape = RectangleShape
                    )
                    .border(BorderStroke(2.dp, MaterialTheme.colors.primary)),
                navigationIcon = {
                    IconButton(onClick = { /**/ }) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                    }
                })
        }) { innerPadding ->
        val userViewModel: UserViewModel = viewModel()
        HomeScreen(Modifier.padding(innerPadding), userViewModel.uiState)
    }
}
