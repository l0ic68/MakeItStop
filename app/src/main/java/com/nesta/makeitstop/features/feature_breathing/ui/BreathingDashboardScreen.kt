package com.nesta.makeitstop.features.feature_breathing.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.TitleLarge
import com.nesta.makeitstop.ui.theme.nunitoFont
import kotlinx.serialization.Serializable

@Serializable
data class ComponentBreathing(
    val title: String,
    val inhaleSeconds: Int,
    val exhaleSeconds: Int,
    val holdSeconds: Int,
    val totalCycle: Int = 5
)

@Composable
fun BreathingDashboardScreen(
    onModuleClick:(ComponentBreathing) -> Unit = {},
    onNavigationClick:() -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleLarge(text = "Espace Respiration")
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth()
        ) {
            val antiStress = ComponentBreathing(
                title = "Anti-stress",
                inhaleSeconds = 5,
                holdSeconds = 3,
                exhaleSeconds = 6
            )
            BreathingDashboardComponent(
                breathing = antiStress,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(0.5f)
                    .clickable(true, onClick = { onModuleClick(antiStress)})
            )

            val coherence = ComponentBreathing(
                title = "5-5 cohérence",
                inhaleSeconds = 5,
                holdSeconds = 5,
                exhaleSeconds = 5
            )
            BreathingDashboardComponent(
                breathing = coherence,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(0.5f)
                    .clickable(true, onClick = { onModuleClick(coherence)})
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        )  {
            val timer = ComponentBreathing(
                title = "4-7-8",
                inhaleSeconds = 4,
                holdSeconds = 7,
                exhaleSeconds = 8
            )
            BreathingDashboardComponent(
                breathing = timer,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(0.5f)
                    .clickable(true, onClick = { onModuleClick(timer)})
            )
            val boxBreathing = ComponentBreathing(
                title = "Box breathing",
                inhaleSeconds = 4,
                holdSeconds = 4,
                exhaleSeconds = 4
            )
            BreathingDashboardComponent(
                breathing = boxBreathing,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(0.5f)
                    .clickable(true, onClick = { onModuleClick(boxBreathing)})
            )
        }
        Button(
            onClick = onNavigationClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF252a86)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            Text("Créér mon timer",
                fontSize = 18.sp,
                color = Color.White,

            )
        }
    }
}

@Composable
fun BreathingDashboardComponent(
    modifier:Modifier = Modifier,
    breathing:ComponentBreathing,
) {
    OutlinedCard(
        modifier = modifier,
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color(0xFF112167),
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, Color(0xFF385292))

    ) {
        Column(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
                .padding(vertical = 10.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){

            Text(
                text = breathing.title,
                fontFamily = nunitoFont,
                fontSize = 14.sp,
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Inhale")
                Text(
                    text = breathing.inhaleSeconds.toString() + "s",
                    fontFamily = nunitoFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Hold")
                Text(
                    text = breathing.holdSeconds.toString() + "s",
                    fontFamily = nunitoFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Exhale")
                Text(
                    text = breathing.exhaleSeconds.toString() + "s",
                    fontFamily = nunitoFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
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
    val antiStress = ComponentBreathing(
        title = "Anti-stress",
        inhaleSeconds = 5,
        holdSeconds = 3,
        exhaleSeconds = 6
    )
    BreathingDashboardComponent(breathing = antiStress)
}