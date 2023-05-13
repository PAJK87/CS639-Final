package com.example.finminds

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finminds.ui.theme.FinMindsTheme

class InvRetPlanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
                androidx.compose.material.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InvRetPlanScreen()
                }
            }
        }
    }
}
@Composable
fun InvRetPlanScreen() {
    LazyColumn {
        item {
            InvRetPlanAppBar()
        }
        item {
            InvRetPlanContent()
        }
        item {
            IRYoutubeCard()
        }
        item {
            InvRetPlanQuiz()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvRetPlanAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                stringResource(R.string.investment_and_retirement_planningAppbar),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    )
}

@Composable
fun InvRetPlanContent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.invret),
                contentDescription = "InvRetPlanes",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 32.dp)
            )
            Text(
                text = "Investment and Retirement Planning",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Investing and retiring planning are important aspects of personal finance that require careful consideration and planning. It is important to have a strong understanding of the various investment options available and to develop a retirement plan that aligns with your financial goals and objectives.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Strategies for investing",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "When it comes to investing, there are various strategies that can be employed, such as diversification, asset allocation, and risk management. It is important to consider your risk tolerance and investment goals when developing an investment strategy.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Why retirement planning?",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Retirement planning is crucial for individuals under 30 because it allows them to start saving early and take advantage of compound interest. By developing a retirement plan, individuals can ensure that they are on track to meet their financial goals and objectives. Additionally, retirement planning can help individuals make informed decisions about their career and financial future. By starting early, individuals can take advantage of tax-advantaged retirement accounts and develop a long-term investment strategy that aligns with their risk tolerance and financial goals.",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}
@Composable
fun IRYoutubeCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=QyAxMOPA7Z0"))
                intent.setPackage("com.google.android.youtube")
                context.startActivity(intent)
            }),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Click here to watch a video!",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.invretvideo),
                contentDescription = "My Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
    }
}

//code for quiz
data class IrQuizQuestion(
    val question: String,
    val options: List<String>,
    val answer: Int
)
val irquizQuestions = listOf(
    IrQuizQuestion(
        question = "What is the maximum amount an individual can contribute to a traditional IRA in 2023?",
        options = listOf("$5,500", "$6,000", "$6,500", "$7,000"),
        answer = 2
    ),
    IrQuizQuestion(
        question = "What is the difference between a 401(k) and a Roth IRA?",
        options = listOf("401(k) contributions are tax-deductible, while Roth IRA contributions are not.", "401(k) contributions are made with pre-tax dollars, while Roth IRA contributions are made with after-tax dollars.", "401(k) contributions are limited to $19,500 per year, while Roth IRA contributions are limited to $6,500 per year.", "401(k) contributions are not subject to income limits, while Roth IRA contributions are."),
        answer = 1
    ),
    IrQuizQuestion(
        question = "What is the difference between a traditional and a Roth 401(k)?",
        options = listOf("Traditional 401(k) contributions are made with pre-tax dollars, while Roth 401(k) contributions are made with after-tax dollars.", "Traditional 401(k) contributions are tax-deductible, while Roth 401(k) contributions are not.", "Traditional 401(k) withdrawals are taxed as ordinary income, while Roth 401(k) withdrawals are tax-free.", "Traditional 401(k) contributions are limited to $19,500 per year, while Roth 401(k) contributions are limited to $6,500 per year."),
        answer = 2
    )
)
@Composable
fun IrQuizQuestionCard(question: IrQuizQuestion, onAnswerSelected: (Boolean) -> Unit) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = question.question,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            question.options.forEachIndexed { index, option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable(onClick = { selectedOption = index })
                ) {
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index },
                        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                    )
                    Text(
                        text = option,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if (selectedOption != null) {
                        onAnswerSelected(selectedOption == question.answer)
                    }
                },
                enabled = selectedOption != null,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}

@Composable
fun InvRetPlanQuiz() {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var numCorrectAnswers by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                text = stringResource(R.string.inTopicQuizTitle),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown ,
                contentDescription = "Expand quiz",
                modifier = Modifier.size(32.dp)
            )

        }
        if (currentQuestionIndex < irquizQuestions.size) {
            IrQuizQuestionCard(
                question = irquizQuestions[currentQuestionIndex]
            ) { isCorrect ->
                if (isCorrect) {
                    numCorrectAnswers++
                }
                currentQuestionIndex++
            }
        } else {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp,
                ),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.quizcomplete),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "You answered $numCorrectAnswers out of ${irquizQuestions.size} questions correctly.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InvRetPlanScreenPreview(){
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InvRetPlanAppBar()
            InvRetPlanContent()
            IRYoutubeCard()
            InvRetPlanQuiz()
        }
    }
}