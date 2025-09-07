package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.ModuleCard
import com.nesta.makeitstop.ui.theme.interFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalScreen() {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                {
                    Text("Journaling du soir")
                }
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
                    Text(
                        "Gratitude du jour",
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        label =  {
                            Text(
                                text = "Une gratidute",
                                color = Color(0xFF999999),
                                style = TextStyle(
                                    fontFamily = interFont,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 14.sp,
                                )
                            )
                        },
                        value = "",
                        onValueChange = {}
                    )
                    TextField(
                        label =  {
                            Text(
                                text = "Une décharge",
                                color = Color(0xFF999999),
                                style = TextStyle(
                                    fontFamily = interFont,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 14.sp,
                                )
                            )
                        },
                        value = "",
                        onValueChange = {}
                    )
                    TextField(
                        label =  {
                            Text(
                                text = "Une intention douce pour demain",
                                color = Color(0xFF999999),
                                style = TextStyle(
                                    fontFamily = interFont,
                                    fontStyle = FontStyle.Italic,
                                    fontSize = 14.sp,
                                )
                            )
                        },
                        value = "",
                        onValueChange = {}
                    )
                    Text("Suite du text", modifier = Modifier.padding(innerPadding))

                }
            }

        }
    }
}


@Composable
@Preview(showBackground = true)
fun Preview(){
    SleepingJournalScreen()
}