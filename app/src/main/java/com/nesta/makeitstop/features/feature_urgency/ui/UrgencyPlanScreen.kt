package com.nesta.makeitstop.features.feature_urgency.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.features.feature_urgency.Module

data class UrgencyAction(
    val icon: String,
    val text: String,
    val color: Color = Color(0xFFF5EDE5),
    val textColor: Color = Color.Black,
    val onClick: () -> Unit = {}
)

@Composable
fun UrgencyPlanScreen(
    modifier: Modifier = Modifier,
    onModuleClick: (Module) -> Unit
) {
    val urgencyActions = listOf(
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_start_icon),
            text = stringResource(R.string.urgency_plan_start),
            color = Color(0xFF4a5cd8),
            textColor = Color(0xFFE6ECFF),
            onClick = {onModuleClick(Module.Urgency)}
        ),
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_breathing_guide_icon),
            text = stringResource(R.string.urgency_plan_breathing_guide),
            onClick = {onModuleClick(Module.Breathing)}
        ),
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_five_senses_icon),
            text = stringResource(R.string.urgency_plan_five_senses),
            onClick = {onModuleClick(Module.FiveSenses)}
        ),
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_written_release_icon),
            text = stringResource(R.string.urgency_plan_written_release),
            onClick = {onModuleClick(Module.Discharge)}
        ),
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_stop_mental_icon),
            text = stringResource(R.string.urgency_plan_stop_mental),
            onClick = {onModuleClick(Module.StopMental)}
        ),
        UrgencyAction(
            icon = stringResource(R.string.urgency_plan_body_reset_icon),
            text = stringResource(R.string.urgency_plan_body_reset),
            onClick = {onModuleClick(Module.CorporalReset)}
        ),
    )
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    0f to Color(0xFF0E1B4A),
                    0.6f to Color(0xFF1B2B6A),
                    1f to Color(0xFF2B2F73)
                )
            ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.urgency_plan_title),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(urgencyActions) { action ->
                    ButtonUrgency(
                        icon = action.icon,
                        text = action.text,
                        color = action.color,
                        textColor = action.textColor,
                        onClick = action.onClick
                    )
                }
            }


        }
    }
}

@Composable
fun ButtonUrgency(
    icon: String,
    text: String,
    color: Color = Color(0xFFF5EDE5),
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .height(50.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = icon,
                fontSize = 20.sp
            )
            Text(
                text = text,
                fontSize = 17.sp
            )
        }
    }
}

@Preview
@Composable
fun preview() {
    UrgencyPlanScreen(
        onModuleClick = {}
    )
}