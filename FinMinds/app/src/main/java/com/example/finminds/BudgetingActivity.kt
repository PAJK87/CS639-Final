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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finminds.ui.theme.FinMindsTheme

class BudgetingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
                androidx.compose.material.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BudgetScreen()
                }
            }
        }
    }
}
@Composable
fun BudgetScreen() {
    LazyColumn {
        item {
            BudgetAppBar()
        }
        item {
            BudgetContent()
        }
        item {
            BYoutubeCard()
        }
        item {
           BudgetQuiz()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                "Budgeting",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    )
}

@Composable
fun BudgetContent() {
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
                painter = painterResource(R.drawable.img_1),
                contentDescription = "Budgetes",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 32.dp)
            )
            Text(
                text = "Budgeting",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Budgeting is the process of creating a plan to manage your income and expenses. It is an important tool for achieving financial stability and reaching your financial goals.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Types of Budgets",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "There are various types of budgets, including personal budgets, business budgets, and project budgets. Each type of budget has its own purpose and can help you manage your finances more effectively.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Budget Planning",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Budget planning involves creating a budget that is tailored to your specific financial situation and goals. This can involve tracking your income and expenses, identifying areas where you can cut back on spending, and setting financial goals for the future.",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}
@Composable
fun BYoutubeCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sVKQn2I4HDM"))
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
                painter = painterResource(id = R.drawable.img_2),
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
data class BQuizQuestion(
    val question: String,
    val options: List<String>,
    val answer: Int
)
val BquizQuestions = listOf(
    QuizQuestion(
        question = "What is the 50/30/20 rule in budgeting?",
        options = listOf("50% of income for needs, 30% for wants, 20% for savings", "50% of income for savings, 30% for needs, 20% for wants", "50% of income for wants, 30% for needs, 20% for savings", "50% of income for needs, 30% for savings, 20% for wants"),
        answer = 0
    ),
    QuizQuestion(
        question = "What is the difference between fixed and variable expenses in budgeting?",
        options = listOf("Fixed expenses are the same every month, while variable expenses can change from month to month", "Fixed expenses can change from month to month, while variable expenses are the same every month", "Fixed expenses are optional, while variable expenses are necessary", "Fixed expenses are necessary, while variable expenses are optional"),
        answer = 0
    ),
    QuizQuestion(
        question = "What is the purpose of a budget?",
        options = listOf("To help you manage your income and expenses", "To restrict your spending", "To make you feel guilty about your spending habits", "To make you feel deprived"),
        answer = 0
    )
)
@Composable
fun BQuizQuestionCard(question: QuizQuestion, onAnswerSelected: (Boolean) -> Unit) {
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
                Text(text = "Submit")
            }
        }
    }
}

@Composable
fun BudgetQuiz() {
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
                text = "Test Your Knowledge",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown ,
                contentDescription = "Expand quiz",
                modifier = Modifier.size(32.dp)
            )

        }
        if (currentQuestionIndex < BquizQuestions.size) {
            BQuizQuestionCard(
                question = BquizQuestions[currentQuestionIndex]
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
                        text = "Quiz complete!",
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "You answered $numCorrectAnswers out of ${quizQuestions.size} questions correctly.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BudgetScreenPreview(){
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BudgetAppBar()
            BudgetContent()
            BYoutubeCard()
            BudgetQuiz()
        }
    }
}