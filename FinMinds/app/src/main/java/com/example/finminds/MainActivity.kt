@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.finminds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finminds.ui.theme.FinMindsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
               Surface(

               ) {
                   Column(
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       MyAppBar()
                       ButtonBox()
                   }
               }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                "Home",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        },

        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        }
    )

}


@Composable
fun ButtonBox(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopicButton()
        QuizButton()
        NewsButton()
    }
}


@Composable
fun TopicButton(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(40.dp)
            .width(140.dp)
            .padding(3.dp)
    ) {
        Text(text = stringResource(R.string.topics))
    }
}

@Composable
fun QuizButton(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(40.dp)
            .width(140.dp)
            .padding(3.dp)
    ) {
        Text(text = stringResource(R.string.random_quiz))
    }
}

@Composable
fun NewsButton(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(40.dp)
            .width(140.dp)
            .padding(3.dp)
    ) {
        Text(
            text = stringResource(R.string.news)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyAppBar()
            ButtonBox()
        }

    }
}