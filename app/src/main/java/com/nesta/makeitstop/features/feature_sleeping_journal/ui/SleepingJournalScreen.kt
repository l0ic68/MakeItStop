package com.nesta.makeitstop.features.feature_sleeping_journal.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.ModuleCard
import com.nesta.makeitstop.ui.theme.interFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepingJournalScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Text("03/09/2025")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
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
                value = "test",
                onValueChange = {}
            )
            Text("Suite du text", modifier = Modifier.padding(innerPadding))

        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview(){
    SleepingJournalScreen()
}