package me.tbsten.kidktuicontestscoringdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.tbsten.kidktuicontestscoringdemo.ui.theme.KidktuicontestscoringdemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KidktuicontestscoringdemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag("root"),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ScoreSection(
                        user = "tbsten",
                        score = 100,
                    )
                }
            }
        }
    }
}

@Composable
fun ScoreSection(
    user: String,
    score: Int,
) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text("$user さん", fontSize = 32.sp)
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("$score", fontSize = 64.sp, fontWeight = FontWeight.Bold)
                Text(" pt", fontSize = 64.sp)
            }
        }
    }
}

@Preview()
@Composable
fun ScoreSectionPreview() {
    ScoreSection(
        user = "テスト用",
        score = 50,
    )
}
