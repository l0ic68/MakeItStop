package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.nesta.makeitstop.features.feature_sleeping_journal.Tab
import com.nesta.makeitstop.ui.theme.nunitoFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalsScreen(
    onTabSelected: (Tab) -> Unit,
    currentTab: Tab,
    modifier: Modifier
) {
    Scaffold(
        //containerColor = MaterialTheme.colorScheme.background,
        //containerColor  = Color(0xFF172242),
        containerColor  = Color.Red,
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
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            SleepingCard()
            SleepingCard()
        }
    }
}

@Composable
fun SleepingCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF9F9FB)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(25.dp),

        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 14.dp)
        ) {
            Text(
                text = "10 Septembre 2025",
                fontFamily = nunitoFont,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 16.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider(
                Modifier
                    .padding(10.dp)
            )
            Text(
                text = "\uD83C\uDF1E Gratitude",
                fontFamily = nunitoFont,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Le sourire d'un ami",
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
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Stresse au travail",
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
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color =  Color(0xFF1B1C42),
                modifier = Modifier.fillMaxWidth())
            Text(
                text = "être patient demain",
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
    SleepingJournalsScreen(
        onTabSelected = {
        },
        currentTab = Tab.Dashboard,
        modifier = Modifier
    )
}
