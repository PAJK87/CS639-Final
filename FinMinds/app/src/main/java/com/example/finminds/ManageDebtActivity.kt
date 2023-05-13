package com.example.finminds

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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

class ManageDebtActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
                Surface(

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ManagingDebtScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ManagingDebtScreen() {
    LazyColumn {
        item {
            ManagingDebtAppBar()
        }
        item {
            ManagingDebtContent()
        }
        item {
            MdYoutubeCard()
        }
        item {
            ManagingDebtQuiz()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagingDebtAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                stringResource(R.string.managingdebtappbar),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    )
}

@Composable
fun ManagingDebtContent() {
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
                painter = painterResource(R.drawable.img_5),
                contentDescription = "ManagingDebtes",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 32.dp)
            )
            Text(
                text = "Managing Debt",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Managing debt is the process of organizing your financial affairs in a way that minimizes your debt liability. This can involve strategies such as creating a budget, paying off high-interest debt first, and negotiating with creditors to reduce interest rates or payment amounts.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Types of Debt",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "There are various types of debt, including credit card debt, student loan debt, mortgage debt, and car loan debt. Each type of debt has its own rules and regulations, and the amount of debt owed depends on a number of factors, such as interest rates and payment terms.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Debt Management",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Debt management is the process of creating a plan to pay off your debt in a timely and efficient manner. This can involve strategies such as consolidating debt, negotiating with creditors, and seeking the help of a financial advisor or credit counselor.",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}
@Composable
fun MdYoutubeCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CHiOBzqcMV8"))
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
                text = stringResource(R.string.youtubeCardClickable),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Image(
                painter = painterResource(id = R.drawable.img_4),
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
data class mdQuizQuestion(
    val question: String,
    val options: List<String>,
    val answer: Int
)
val mdquizQuestions = listOf(
    mdQuizQuestion(
        question = "What is the snowball method of debt repayment?",
        options = listOf("Paying off the debt with the highest interest rate first.", "Paying off the debt with the lowest balance first.", "Paying off the debt with the highest balance first.", "Paying off the debt with the lowest interest rate first."),
        answer = 1
    ),
    mdQuizQuestion(
        question = "What is a debt consolidation loan?",
        options = listOf("A loan that combines multiple debts into a single loan with a lower interest rate.", "A loan that is only available to individuals with good credit.", "A loan that is backed by collateral.", "A loan that is used to pay off a single debt."),
        answer = 0
    ),
    mdQuizQuestion(
        question = "What is the difference between a fixed-rate and variable-rate loan?",
        options = listOf("A fixed-rate loan has a fixed interest rate, while a variable-rate loan has a variable interest rate.", "A fixed-rate loan has a variable interest rate, while a variable-rate loan has a fixed interest rate.", "A fixed-rate loan is only available to individuals with good credit, while a variable-rate loan is available to anyone.", "A fixed-rate loan has a higher interest rate than a variable-rate loan."),
        answer = 0
    )
)
@Composable
fun mdQuizQuestionCard(question: mdQuizQuestion, onAnswerSelected: (Boolean) -> Unit) {
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
fun ManagingDebtQuiz() {
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
        if (currentQuestionIndex < mdquizQuestions.size) {
            mdQuizQuestionCard(
                question = mdquizQuestions[currentQuestionIndex]
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
                        text = "You answered $numCorrectAnswers out of ${mdquizQuestions.size} questions correctly.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManagingDebtScreenPreview(){
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ManagingDebtAppBar()
            ManagingDebtContent()
            MdYoutubeCard()
            ManagingDebtQuiz()
        }
    }
}