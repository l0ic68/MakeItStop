package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import com.nesta.makeitstop.ui.theme.nunitoFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalsScreen(
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    recordList: List<SleepingJournalRecord>,
    onDelete: (Int) -> Unit = {},
    modifier: Modifier
) {
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
            items(
                items = recordList,
                key = { task: SleepingJournalRecord -> task.id }
            ) { task ->
                SleepingCard(task, onDelete)
            }
        }

        BottomSleepingJournalingNavigation(
            onTabSelected = onTabSelected,
            currentTab = currentTab,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SleepingCard(
    task: SleepingJournalRecord,
    onDelete: (Int) -> Unit = {}
) {

    var isCardOpen by remember { mutableStateOf(true) }
    var clickHold by remember { mutableStateOf(false) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF9F9FB)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(25.dp),

        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 16.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = { isCardOpen = !isCardOpen },
            )

    ) {
        Box(
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 14.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.combinedClickable(
                        onClick = {
                            clickHold = false
                            isCardOpen = !isCardOpen
                        },
                        onLongClick = { clickHold = true }
                    )
                ) {
                    Text(
                        text = task.date,
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        color = Color(0xFF444654),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight()
                    )

                    Button(
                        onClick = {
                            isCardOpen = !isCardOpen
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    )
                    {
                        if (isCardOpen) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    }
                }
                if (isCardOpen) {
                    HorizontalDivider(
                        Modifier
                            .padding(10.dp)
                    )
                    Text(
                        text = "\uD83C\uDF1E " + stringResource(R.string.sleeping_journal_gratitude), // TODO LOU Ajouter new Icon
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        color = Color(0xFF1B1C42),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = task.firstQuestion,
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF444654),
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "\uD83C\uDF19 " + stringResource(R.string.sleeping_journal_release),
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        color = Color(0xFF1B1C42),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = task.secondQuestion,
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF444654),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "\uD83C\uDF31 " + stringResource(R.string.sleeping_journal_intention),
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                        color = Color(0xFF1B1C42),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = task.thirdQuestion,
                        fontFamily = nunitoFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color(0xFF444654),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
            androidx.compose.animation.AnimatedVisibility(
                clickHold,
                modifier = Modifier.align(Alignment.TopEnd),
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                IconButton(
                    onClick = {
                        onDelete(task.id)
                    },
                    modifier = Modifier.padding(top = 2.dp, end = 2.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Supprimer",
                        tint = Color(0xFF444654)
                    )
                }

            }
        }

    }
}

@Composable
@Preview
fun CardPreview() {

    val fakeRecords = listOf(
        SleepingJournalRecord(
            id = 0,
            date = "16 Septembre 2028",
            firstQuestion = "Un bon café le matin",
            secondQuestion = "Un peu de stress au travail",
            thirdQuestion = "Prendre plus de temps pour respirer",
            epoch = 0
        ),
        SleepingJournalRecord(
            id = 1,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil\"Une promenade au soleil\"Une promenade au soleil\"Une promenade au soleil\"Une promenade au soleil\"Une promenade au soleil\"Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 2,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 3,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 4,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 5,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 6,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        ),
        SleepingJournalRecord(
            id = 7,
            date = "16 Septembre 2028",
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        )
    )
    PreviewBackground {
        SleepingJournalsScreen(
            onTabSelected = {
            },
            currentTab = Tab.Dashboard,
            recordList = fakeRecords,
            modifier = Modifier
        )
    }
}
