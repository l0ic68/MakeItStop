package com.nesta.makeitstop.features.feature_breathing.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.TitleLarge
import com.nesta.makeitstop.features.feature_breathing.data.viewmodel.BreathingDetails
import com.nesta.makeitstop.features.feature_breathing.data.viewmodel.BreathingUiState
import com.nesta.makeitstop.ui.theme.poppinFont

enum class BreathingRow {
    Inhale,
    Exhale,
    Hold,
    TotalCycle
}

@Composable
fun BreathingTimerCreationScreen(
    breathingUiState: State<BreathingUiState>,
    onAddBreathing: (BreathingDetails) -> Unit,
    addBreathingClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleLarge("Create your timer")
        Text(
            text = "Name",
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = breathingUiState.value.breathingDetails.name,

            onValueChange = {
                onAddBreathing(
                    breathingUiState.value.breathingDetails.copy(name = it)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(
            BreathingRow.Inhale,
            name = "Inhale",
            breathingUiState.value.breathingDetails.inhale,
            onAddBreathing,
            breathingUiState
        )
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(
            BreathingRow.Hold,
            name = "Hold",
            breathingUiState.value.breathingDetails.hold,
            onAddBreathing,
            breathingUiState
        )
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(
            BreathingRow.Exhale,
            name = "Exhale",
            breathingUiState.value.breathingDetails.exhale,
            onAddBreathing,
            breathingUiState
        )
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(
            BreathingRow.TotalCycle,
            name = "Cycles",
            breathingUiState.value.breathingDetails.totalCycles,
            onAddBreathing,
            breathingUiState
        )

        Button(
            onClick = addBreathingClick,
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
fun EditBreathingRowComponent(
    rowType: BreathingRow,
    name: String = "Inhale",
    value: Int = 3,
    onAddBreathing: (BreathingDetails) -> Unit,
    breathingUiState: State<BreathingUiState>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.3f),
            text = name,
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,
        )

        Text(
            text = "< ",
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,
            modifier = Modifier.clickable(
                onClick = {
                    val current = breathingUiState.value.breathingDetails
                    val updated = when (rowType) {
                        BreathingRow.Inhale -> current.copy(inhale = (value -1).coerceAtLeast(0))
                        BreathingRow.Hold -> current.copy(hold = (value -1).coerceAtLeast(0))
                        BreathingRow.Exhale -> current.copy(exhale =  (value -1).coerceAtLeast(0))
                        BreathingRow.TotalCycle -> current.copy(totalCycles =  (value -1).coerceAtLeast(0))
                    }
                    current.copy(exhale = (value - 1).coerceAtLeast(0))

                    onAddBreathing(updated)
                }
            )
        )

        Text(
            text = value.toString(),
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,

            )

        Text(
            text = "> ",
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,
            modifier = Modifier.clickable(
                onClick = {
                    val current = breathingUiState.value.breathingDetails
                    val updated = when (rowType) {
                        BreathingRow.Inhale -> current.copy(inhale = value + 1)
                        BreathingRow.Hold -> current.copy(hold = value + 1)
                        BreathingRow.Exhale -> current.copy(exhale = value + 1)
                        BreathingRow.TotalCycle -> current.copy(totalCycles = value + 1)
                    }
                    onAddBreathing(updated)
                }
            )
        )
    }
}

@Preview
@Composable
fun PreviewBreathingTimerCreationScreen() {

    val fakeState = remember { mutableStateOf(BreathingUiState()) }

    PreviewBackground {
        BreathingTimerCreationScreen(
            breathingUiState = fakeState,
            onAddBreathing = {},
            addBreathingClick = {}
        )
    }
}