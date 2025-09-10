package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalsScreen(
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
                modifier)
        }
    ) { innerPadding ->
        Text("Text",
        modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun SleepingCard() {

    Card() {
        Text("Test")
    }
}

@Composable
@Preview
fun CardPreview() {
    SleepingCard()
}
