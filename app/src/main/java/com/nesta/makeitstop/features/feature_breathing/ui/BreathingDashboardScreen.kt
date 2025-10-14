package com.nesta.makeitstop.features.feature_breathing.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.TitleLarge

@Composable
fun BreathingDashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        TitleLarge(text = "Espace Respiration")
        OutlinedCard(
            modifier = Modifier.fillMaxWidth(0.4f),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            ),

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text("Anti Stress")
                Text("Inhale 5S")
                Text("Hold 3S")
                Text("Exhale 6S")
            }

        }
    }
}

@Preview
@Composable
fun BreathingDashboardScreenPreview() {
    PreviewBackground {
        BreathingDashboardScreen()
    }
}

@Preview
@Composable
fun BreathingDashboardModuleScreenPreview() {
    PreviewBackground {
       // BreathingDashboardScreen()
    }
}