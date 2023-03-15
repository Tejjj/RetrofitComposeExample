package com.example.retrofitcomposeexample.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofitcomposeexample.R
import com.example.retrofitcomposeexample.data.UserInfo
import com.example.retrofitcomposeexample.ui.viewModel.UiState


@Composable
fun HomeScreen(innerPadding: Modifier = Modifier, uiState: UiState) {
    when (uiState) {
        is UiState.Loading -> LoadingScreen(innerPadding)
        is UiState.Error -> ErrorScreen(uiState.errorMsg, innerPadding)
        is UiState.Success -> DisplayUserList(uiState.userList, innerPadding)
    }
}

@Composable
fun DisplayUserList(userList: List<UserInfo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.light_gray)),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        items(userList) { item: UserInfo ->
            Card(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ) {
                UserRow(item)
            }
        }
    }
}

@Composable
fun UserRow(item: UserInfo) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(64.dp)
            .background(MaterialTheme.colors.background),
    ) {
        TextCompose(item.id.toString(), modifier = Modifier.weight(1f))

        TextCompose(item.name, textAlign = TextAlign.Start, modifier = Modifier.weight(2f))
    }
}

@Composable
fun TextCompose(
    displayValue: String,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
) {
    Text(
        text = displayValue,
        textAlign = textAlign,
        fontSize = 20.sp,
        color = Color.Black,
        style = MaterialTheme.typography.body1,
        modifier = modifier.padding(8.dp),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun ErrorScreen(errorMsg: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = errorMsg,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.loading_image),
            contentDescription = null
        )
    }
}
