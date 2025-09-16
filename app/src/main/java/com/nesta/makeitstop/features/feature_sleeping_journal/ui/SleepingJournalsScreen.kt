package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.features.feature_sleeping_journal.data.model.SleepingJournalRecord
import com.nesta.makeitstop.ui.theme.nunitoFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalsScreen(
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    recordList: List<SleepingJournalRecord>,
    modifier: Modifier
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        //containerColor  = Color(0xFF172242),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    //containerColor = MaterialTheme.colorScheme.background
                    containerColor = Color(0xFF172242),

                    ),
                title =
                    {
                        Text(
                            text = "Journaling",
                            fontFamily = nunitoFont,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
            )
        },
        bottomBar = {
            BottomSleepingJournalingNavigation(
                onTabSelected,
                currentTab,
                modifier)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(
                items = recordList,
                key = { task: SleepingJournalRecord -> task.id}
            ) { task ->
                SleepingCard(task)
            }
        }
    }
}

@Composable
fun SleepingCard(task:SleepingJournalRecord) {
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
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 14.dp)
        ) {
            Text(
                text = task.date,
                fontFamily = nunitoFont,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 16.sp,
                color =  Color(0xFF444654),
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider(
                Modifier
                    .padding(10.dp)
            )
            Text(
                text = "\uD83C\uDF1E Gratitude",
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = task.firstQuestion,
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color =  Color(0xFF444654),
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 20.dp)

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "\uD83C\uDF19 Décharge",
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = task.secondQuestion,
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color =  Color(0xFF444654),
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "\uD83C\uDF31 Intention",
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth())
            Text(
                text = task.thirdQuestion,
                fontFamily = nunitoFont,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color =  Color(0xFF444654),
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

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
            firstQuestion = "Une promenade au soleil",
            secondQuestion = "Courses fatigantes",
            thirdQuestion = "Être patient demain",
            epoch = 1
        )
    )
    SleepingJournalsScreen(
        onTabSelected = {
        },
        currentTab = Tab.Dashboard,
        recordList = fakeRecords,
        modifier = Modifier
    )
}
