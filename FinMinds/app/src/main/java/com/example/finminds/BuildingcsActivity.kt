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
class BuildingcsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinMindsTheme {
                androidx.compose.material.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildingcsScreen()
                }
            }
        }
    }
}

@Composable
fun BuildingcsScreen() {
    LazyColumn {
        item {
            BuildingcsAppBar()
        }
        item {
            BuildingcsContent()
        }
        item {
            BcsYoutubeCard()
        }
        item {
            BuildingcsQuiz()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildingcsAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF4953BB)),
        title = {
            Text(
                "Building Credit Score",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    )
}

@Composable
fun BuildingcsContent() {
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
                painter = painterResource(R.drawable.creditscore),
                contentDescription = "Buildingcses",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 32.dp)
            )
            Text(
                text = "Building Credit Score",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Building credit score is the process of establishing and maintaining a good credit history. A good credit score can help you qualify for loans, credit cards, and other financial products at favorable terms.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Factors that Affect Credit Score",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Several factors can affect your credit score, including payment history, credit utilization, length of credit history, types of credit used, and new credit inquiries. It's important to understand how these factors impact your credit score and to take steps to improve them if necessary.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Tips for Building Credit Score",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "To build your credit score, you can take steps such as paying your bills on time, keeping your credit utilization low, maintaining a mix of credit types, and checking your credit report regularly for errors. It's also important to avoid opening too many new credit accounts at once, as this can negatively impact your credit score.",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}
@Composable
fun BcsYoutubeCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=eghPxmv4uYw"))
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
                painter = painterResource(id = R.drawable.credit_score),
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
data class BcsQuizQuestion(
    val question: String,
    val options: List<String>,
    val answer: Int
)
val BcsquizQuestions = listOf(
    BcsQuizQuestion(
        question = "What is a credit score?",
        options = listOf("A numerical representation of a person's creditworthiness", "The amount of money a person owes on their credit cards", "The number of credit cards a person has", "The amount of money a person earns each year"),
        answer = 0
    ),
    BcsQuizQuestion(
        question = "What factors affect a person's credit score?",
        options = listOf("Payment history, credit utilization, length of credit history, types of credit used, and new credit inquiries", "Income, age, gender, and education level", "Marital status, number of children, and occupation", "Political affiliation, religion, and ethnicity"),
        answer = 0
    ),
    BcsQuizQuestion(
        question = "What is a good credit score?",
        options = listOf("Generally, a score of 670 or higher is considered good", "Generally, a score of 500 or higher is considered good", "Generally, a score of 800 or higher is considered good", "There is no such thing as a good credit score"),
        answer = 0
    )
)
@Composable
fun BcsQuizQuestionCard(question: BcsQuizQuestion, onAnswerSelected: (Boolean) -> Unit) {
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
fun BuildingcsQuiz() {
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
        if (currentQuestionIndex < BcsquizQuestions.size) {
            BcsQuizQuestionCard(
                question = BcsquizQuestions[currentQuestionIndex]
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
                        text = "You answered $numCorrectAnswers out of ${BcsquizQuestions.size} questions correctly.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuildingcsScreenPreview(){
    FinMindsTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BuildingcsAppBar()
            BuildingcsContent()
            BcsYoutubeCard()
            BuildingcsQuiz()
        }
    }
}