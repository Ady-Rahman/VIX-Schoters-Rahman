package com.rahmanadiyanto.newsfinaltask.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahmanadiyanto.newsfinaltask.screen.news.NewsDisplay
import com.rahmanadiyanto.newsfinaltask.ui.theme.NewsFinalTaskTheme
import com.rahmanadiyanto.newsfinaltask.ui.theme.Typography


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "New Education",
            style = Typography.h2,
            color = Color.Black,
            fontSize = 45.sp
        )
        Spacer(Modifier.size(100.dp))
        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(
                start = 20.dp, top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            Text(text = "News")
        }
        Spacer(Modifier.size(15.dp))
        Button(onClick = { /*TODO*/ },
            contentPadding = PaddingValues(
                start = 20.dp, top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )) {
            Text(text = "Bookmark")
        }
        Spacer(Modifier.size(15.dp))
        Button(onClick = { /*TODO*/ },
            contentPadding = PaddingValues(
                start = 20.dp, top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )) {
            Text(text = "Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsFinalTaskTheme{
        HomeScreen()
    }
}