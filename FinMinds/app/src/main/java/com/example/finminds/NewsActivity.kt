package com.example.finminds

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.finminds.ui.theme.FinMindsTheme

class NewsActivity : ComponentActivity() {

    private val newsView by viewModels<NewsView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Surface() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    NewsAppBar()
                    var bloombergList = newsView.bloombergNewsResponse
                    var wsjList = newsView.wsjNewsResponse
                    newsList(articleList = wsjList)
                    newsView.getWsjList()
                    newsView.getBloombergList()
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
                publishedAt = "4/32",
                content = "Hjshfljkhasldfjhlaksdjfla"
            ))
            NewsAppBar()
            newsList(articleList = listOfArticles )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar(){
    var shouldShowHomeScreen by rememberSaveable { mutableStateOf(true) }
    val context = LocalContext.current

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                "News",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        },

        navigationIcon = {
            IconButton(
                onClick = {

                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        },
        actions = {
            SourcesDropDownMenu()
        }
    )

}

@Composable
fun SourcesDropDownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .wrapContentSize(Alignment.TopEnd)
    ) {
        Text(
            text = "Sources",
            color = Color.White,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
        )
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.White,
                modifier = Modifier.offset(x = (-10).dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Wall Street Journal") },
                onClick = { Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Bloomberg News") },
                onClick = { }
            )
        }
    }
}




@Composable
fun newsList(articleList: Array<NewsData.Articles>) {
    LazyColumn {
        itemsIndexed(items = articleList) { index, item ->
            newsItem(article = item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun newsItem(article: NewsData.Articles) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),

    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                AsyncImage(
                    model = article.urlToImage,
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
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
//                    Text(
//                        text = article.source.name,
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier
//                            .background(
//                                Color.LightGray
//                            )
//                            .padding(4.dp)
//                    )
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

fun generateNewsList(source : String){

}