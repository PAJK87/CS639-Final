package com.example.finminds

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finminds.ui.theme.FinMindsTheme

class TopicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
                Surface(

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TopicAppBar()
                        TopicBox()
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicAppBar(){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                stringResource(R.string.topicsappbar),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    )

}


@Composable
fun TopicBox(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        TaxButton()
        BudgetingButton()
        BuildingCSButton()
        ManagingDebt()
        InvAndRetPlanning()
    }
}


@Composable
fun TaxButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, TaxActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .height(70.dp)
            .width(250.dp)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.tax),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}
@Composable
fun BudgetingButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, BudgetingActivity::class.java)
            context.startActivity(intent)
                  },
        modifier = Modifier
            .height(70.dp)
            .width(250.dp)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.budgetingbutton),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}
@Composable
fun BuildingCSButton(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, BuildingcsActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .height(70.dp)
            .width(250.dp)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.buildingcsbutton),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun ManagingDebt(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, ManageDebtActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
            .height(70.dp)
            .width(250.dp)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.managingdebtbutton),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}
@Composable
fun InvAndRetPlanning(){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, InvRetPlanActivity::class.java)
            context.startActivity(intent)
        },
        modifier = Modifier
//            .height(70.dp)
            .width(260.dp)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.investingretirebutton),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
            )
    }
}


@Preview(showBackground = true)
@Composable
fun TopicPreview() {
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicAppBar()
            TopicBox()
        }
    }
}
