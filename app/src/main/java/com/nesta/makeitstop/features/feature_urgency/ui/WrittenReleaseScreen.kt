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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionUiState
import com.nesta.makeitstop.features.feature_urgency.data.viewmodel.WrittenReleaseUiState
import com.nesta.makeitstop.features.feature_urgency.data.viewmodel.formatTime

@Composable
fun WrittenReleaseScreen(
    writtenReleaseUiState: State<WrittenReleaseUiState>,
    onStartTimer: () -> Unit,
    onSaveTimer: () -> Unit,
    onTextChange: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = stringResource(R.string.urgency_release_title),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFFE6ECFF),
        )
        Text(
            text = stringResource(R.string.urgency_release_description),
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = Color(0xFFE6ECFF)
        )
        TextField(
            value = writtenReleaseUiState.value.text,
            enabled = writtenReleaseUiState.value.isTextEnabled,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    text = stringResource(R.string.urgency_release_textfield_placeholder),
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .clip(RoundedCornerShape(12.dp))
        )

        Text(
            text = writtenReleaseUiState.value.timer.formatTime(),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onStartTimer,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5450a3)
                )
            ) {
                Text(
                    text = stringResource(R.string.urgency_release_button_start_timer),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            Button(
                onClick = onSaveTimer,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFeadffa)
                )
            ) {
                Text(
                    text = stringResource(R.string.urgency_release_button_save),
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }

}


@Composable
@Preview()
fun WrittenReleaseScreenPreview() {
    val fakeState = remember { mutableStateOf(WrittenReleaseUiState()) }
    PreviewBackground {
        WrittenReleaseScreen(
            writtenReleaseUiState = fakeState,
            {
            },
            {}
        )
    }
}