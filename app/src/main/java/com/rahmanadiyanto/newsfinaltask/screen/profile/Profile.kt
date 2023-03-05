package com.rahmanadiyanto.newsfinaltask.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahmanadiyanto.newsfinaltask.R
import com.rahmanadiyanto.newsfinaltask.screen.home.HomeScreen
import com.rahmanadiyanto.newsfinaltask.screen.news.NewsList
import com.rahmanadiyanto.newsfinaltask.ui.theme.*

@Composable
fun Profile() {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = TransparentBlack_x87,
                title = { Text(text = "Profile", color = TransparentWhite_x87) }
            )
        }) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = padding),
            color = TransparentBlack_x67
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(id = R.drawable.picture),
                    contentDescription = "profile"
                )
                Spacer(Modifier.size(15.dp))
                Text(text = "Rahman Adiyanto", color = Color.White)
                Spacer(Modifier.size(15.dp))
                Text(text = "Github : Ady-Rahman", color = Color.White)
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsFinalTaskTheme {
        Profile()
    }
}
