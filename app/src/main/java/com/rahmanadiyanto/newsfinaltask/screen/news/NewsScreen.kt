package com.rahmanadiyanto.newsfinaltask.screen.news

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.rahmanadiyanto.newsfinaltask.R
import com.rahmanadiyanto.newsfinaltask.data.remote.model.Article
import com.rahmanadiyanto.newsfinaltask.ui.theme.TransparentWhite_x87
import com.rahmanadiyanto.newsfinaltask.util.Constants.Companion.API_KEY
import com.rahmanadiyanto.newsfinaltask.util.Constants.Companion.QUERY_NEWS
import com.rahmanadiyanto.newsfinaltask.util.Constants.Companion.SEARCH_TITLE
import com.rahmanadiyanto.newsfinaltask.util.Resource

@Composable
fun NewsScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    fun launch() {
        newsViewModel.getNews(QUERY_NEWS, SEARCH_TITLE, API_KEY)
    }

    launch()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(val newsResponse = newsViewModel.news.value){
            is Resource.Loading -> {
                CircularProgressIndicator(color = TransparentWhite_x87)
            }
            is Resource.Success -> {
                NewsDisplay(
                    newsList = newsResponse.value,
                    onClickToDetailScreen = {
                        openTab(context, it)
                    }
                )
            }
            is Resource.Error -> {
                ErrorButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Error occurred. Please try again",
                    onClick = {
                        launch()
                    }
                )
            }
            else -> {}
        }
    }

}

fun openTab(context: Context, article: Article) {
    val packageName = "com.android.chrome"
    val url = article.url
    val builder = CustomTabsIntent.Builder()

    builder.setShowTitle(true)

    builder.setInstantAppsEnabled(true)
    builder.setToolbarColor(ContextCompat.getColor(context, R.color.black))

    val customBuilder = builder.build()

    customBuilder.intent.setPackage(packageName)
    customBuilder.launchUrl(context, Uri.parse(url))

}

