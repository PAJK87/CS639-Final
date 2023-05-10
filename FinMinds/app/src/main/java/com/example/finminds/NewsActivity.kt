package com.example.finminds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.finminds.ui.theme.FinMindsTheme

class NewsActivity : ComponentActivity() {

    private val newsView by viewModels<NewsView>()
    private val TAG: String = NewsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsView.getNewsList()
        setContent{
            Surface() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    NewsAppBar()
                    val newsList = newsView.newsResponse
                    newsList(newsList)
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {

    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val listOfArticles = arrayOf(NewsData.Articles(
                source = NewsData.Source(id = "78", name = "The Wall Street Journal"),
                author = "wsj",
                title = "Federal Reserve Raises Rates, Signals Potential Pause...",
                description = "Central bank officials remove earlier guidance that had pointed to further increases",
                url = "hj",
                urlToImage = "https://images.wsj.net/im-775148/social",
                publishedAt = "2023-05-08T11:00:04Z",
                content = "Hjshfljkhasldfjhlaksdjfla"
            ))

            NewsAppBar()
            newsList(listOfArticles)
        }

    }
}

fun isoTOString(string:String): String{
    val newDate : String
    val month:String = string.substring(5,7)
    val date = string.substring(8,10)
    val year = string.substring(0,4)
    newDate = "$month/$date/$year"
    return newDate
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(){

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                "News",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },

        navigationIcon = {

        },
        actions = {
        }
    )

}


@Composable
fun newsList(newsList: Array<NewsData.Articles>) {
    LazyColumn {
        itemsIndexed(items = newsList) { index, item ->
            newsItem(article = item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newsItem(article: NewsData.Articles) {
    val uriHandler = LocalUriHandler.current
    val image = if (article.urlToImage == null) null else article.urlToImage
    val author = if(article.author == null) "None" else article.author
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            uriHandler.openUri(article.url)
        }

    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = article.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = isoTOString(article.publishedAt),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = article.description,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }
}
