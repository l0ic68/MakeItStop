package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.QuestionItem
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournal
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalUiState
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
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title =
                    {
                        Text(
                            text = "Journaling du soir",
                            fontSize = 30.sp
                        )
                    }
            )
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
                .fillMaxWidth()

        ) {
            Card(
                modifier = Modifier
                    .padding(25.dp)
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
                        content = {
                            Text("Mise en ligne" )
                        }
                    )
                }
            }

        }
    }
}