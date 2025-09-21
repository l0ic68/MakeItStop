package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.QuestionItem
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournal
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalUiState
import com.nesta.makeitstop.ui.theme.MakeItStopTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalScreen(
    onClick: () -> Unit,
    sleepingJournalUiState: SleepingJournalUiState,
    onSleepingJournalValueChange: (SleepingJournal) -> Unit = {},
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    modifier: Modifier
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopBarSleepingJournalingNavigation()
        },
        bottomBar = {
            BottomSleepingJournalingNavigation(
                onTabSelected,
                currentTab,
                modifier
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Card(
                modifier = Modifier
                    .padding(bottom = 25.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
                    val currentDate = LocalDateTime.now().format(formatter)
                    Text(
                        text = currentDate.toString(),
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                    )

                    QuestionItem(
                        question = "Une gratitude",
                        text = sleepingJournalUiState.journal.firstQuestion,
                        canIncreaseSize = true,
                        onValueChange = {
                            onSleepingJournalValueChange(
                                sleepingJournalUiState.journal.copy(
                                    firstQuestion = it
                                )
                            )
                        })
                    QuestionItem(
                        question = "Une décharge :",
                        text = sleepingJournalUiState.journal.secondQuestion,
                        canIncreaseSize = true,
                        onValueChange = {
                            onSleepingJournalValueChange(
                                sleepingJournalUiState.journal.copy(
                                    secondQuestion = it
                                )
                            )
                        },
                    )
                    QuestionItem(
                        question = "Une intention douce pour demain :",
                        text = sleepingJournalUiState.journal.thirdQuestion,
                        canIncreaseSize = true,
                        onValueChange = {
                            onSleepingJournalValueChange(
                                sleepingJournalUiState.journal.copy(
                                    thirdQuestion = it
                                )
                            )
                        },
                    )

                    Button(
                        onClick = onClick,
                        modifier = Modifier.padding(vertical = 10.dp),
                        enabled = sleepingJournalUiState.isEntryValid,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = Color.White,
                            disabledContainerColor = Color.Gray,
                            disabledContentColor= Color.White
                        ),
                        content = {
                            Text("Mise en ligne" )
                        }
                    )
                }
            }

        }
    }
}


@Preview(name = "SleepingJournal - Light", showBackground = true)
@Preview(
    name = "SleepingJournal - Dark",
    showBackground = true,
)
@Composable
fun SleepingJournalScreenPreview() {
    MakeItStopTheme {
        val previewState = SleepingJournalUiState(
            journal = SleepingJournal(
                firstQuestion = "Le sourire d’un ami",
                secondQuestion = "Stress au travail",
                thirdQuestion = "Être patient demain"
            ),
            isEntryValid = true
        )
        SleepingJournalScreen(
            onClick = {},
            sleepingJournalUiState = previewState,
            onSleepingJournalValueChange = {},
            onTabSelected = { /* no-op */ },
            currentTab = Tab.Dashboard,
            modifier = Modifier
        )
    }
}