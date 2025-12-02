package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.BottomBarState
import com.nesta.makeitstop.LocalBottomBarState
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.QuestionItem
import com.nesta.makeitstop.features.feature_addiction.ui.CustomSlider
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournal
import com.nesta.makeitstop.features.feature_sleeping_journal.data.viewmodel.SleepingJournalUiState
import com.nesta.makeitstop.ui.theme.MakeItStopTheme
import com.nesta.makeitstop.ui.theme.PrimaryDark
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.poppinFont
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
    AddSleepingBottomBar(
        onTabSelected,
        currentTab,
        modifier
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(top = 0.dp, start = 25.dp, end = 25.dp)
            .fillMaxSize()
    ) {
        Spacer(Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.sleeping_journal_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE6ECFF),
            textAlign = TextAlign.Center
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
        ) {
            val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
            val currentDate = LocalDateTime.now().format(formatter)
            item {
                Text(
                    text = currentDate.toString(),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                )
            }
            item {
                QuestionItem(
                    question = stringResource(R.string.sleeping_journal_gratitude),
                    text = sleepingJournalUiState.journal.firstQuestion,
                    canIncreaseSize = true,
                    onValueChange = {
                        onSleepingJournalValueChange(
                            sleepingJournalUiState.journal.copy(
                                firstQuestion = it
                            )
                        )
                    })
            }
            item {
                QuestionItem(
                    question = stringResource(R.string.sleeping_journal_release),
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
            }
            item {
                QuestionItem(
                    question = stringResource(R.string.sleeping_journal_sweet_intention),
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
            }
            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),

                    colors = CardDefaults.cardColors(containerColor = PrimaryWhite),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Une note de la journée",
                            fontSize = 16.sp,
                            fontFamily = poppinFont,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal,
                            color = PrimaryDark,
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                        CustomSlider(
                            modifier = Modifier,
                            sliderPosition = 5f,
                            onValueChange = {
                            },
                            textColor = Color.Black
                        )
                    }
                }

            }
            item {
                Button(
                    onClick = onClick,
                    modifier = Modifier.padding(vertical = 10.dp),
                    enabled = sleepingJournalUiState.isEntryValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.White
                    ),
                    content = {
                        Text(stringResource(R.string.app_confirme))
                    }
                )
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
        val fakeBottomBar = remember { BottomBarState() }

        CompositionLocalProvider(LocalBottomBarState provides fakeBottomBar) {

            PreviewBackground {
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
    }
}