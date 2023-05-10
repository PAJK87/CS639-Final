@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.finminds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                       MyApp()
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
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },
    )
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowHomeScreen by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowHomeScreen) {
            WelcomeScreen(onContinueClicked = { shouldShowHomeScreen = false})
        } else {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(){
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
@Composable
fun WelcomeScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier) {
    Surface(color = colorResource(id = R.color.Main)) {
        

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(
            painter = painterResource(id = R.drawable.finminds_logo),
            contentDescription = "FinMinds Logo",
        )
        Text(
            text = "Welcome to FinMinds!",
            color = Color.White,
            fontSize = 30.sp
        )
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .width(250.dp)
            ,
            onClick = onContinueClicked,
            colors = ButtonDefaults.buttonColors(Color.White)
        ){
            Text(
                text= "Continue",
                color = colorResource(id = R.color.Main),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
        }
    }
    }
}

@Composable
fun ButtonBox(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        TopicButton()
        QuizButton()
        NewsButton()
    }
}

@Composable
fun TopicButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, TopicActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
//            .height(40.dp)
            .width(250.dp)
            .padding(3.dp)
    ) {
        Text(
            text = stringResource(R.string.topics),
            fontSize = 30.sp
        )
    }
}

@Composable
fun QuizButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, RandomQuizActivity::class.java)
            context.startActivity(intent)
                  },
        modifier = Modifier
//            .height(40.dp)
            .width(250.dp)
            .padding(3.dp)
    ) {
        Text(
            text = stringResource(R.string.random_quiz),
            fontSize = 30.sp
        )
    }
}

@Composable
fun NewsButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, NewsActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
//            .height(40.dp)
            .width(250.dp)
            .padding(3.dp)
    ) {
        Text(
            text = stringResource(R.string.news),
            fontSize = 30.sp
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

@Preview(showBackground = true)
@Composable
fun Preview2() {
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Surface(color = colorResource(id = R.color.Main)) {
                WelcomeScreen(onContinueClicked = { /*TODO*/ })
            }

        }

    }
}