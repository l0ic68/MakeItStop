package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.QuestionItem
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordDetails
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordUiState
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.poppinFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeelingScreen(
    dailyRecordUiState: AddictionDailyRecordUiState,
    onDailyRecordValueChange: (AddictionDailyRecordDetails) -> Unit = {},
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Mon ressenti",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF)
            )
            Spacer(Modifier.size(40.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "A quel point je regrette ?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryWhite,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                CustomSlider(
                    dailyRecordUiState.addictionDailyRecordDetails.feelingScore,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(
                                feelingScore = it
                            )
                        )
                    }
                )

                QuestionItem(
                    question = "Dans quel contexte étais-je ?",
                    text = dailyRecordUiState.addictionDailyRecordDetails.fourthAnswer,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(
                                fourthAnswer = it
                            )
                        )
                    })
                QuestionItem(
                    question = "Comment je me sens maintenant",
                    text = dailyRecordUiState.addictionDailyRecordDetails.fifthAnswer,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(
                                fifthAnswer = it
                            )
                        )
                    })


                Button(
                    onClick = onSaveClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = dailyRecordUiState.isSecondEntryValid,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = PrimaryWhite,
                        containerColor = Color(0xFF5468e8),
                    )
                ) {
                    Text(
                        text = "Enregistrer mon ressenti",
                        fontSize = 18.sp,
                        fontFamily = poppinFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    )
                }
            }
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomSlider(
    sliderPosition: Float,
    onValueChange: (Float) -> Unit
) {
    Text(
        text = "${sliderPosition.toInt()}",
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
        color = PrimaryWhite,
        modifier = Modifier.padding(vertical = 12.dp)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF4CAF50),
                                Color(0xFFFFEB3B),
                                Color(0xFFF44336)
                            )
                        ),
                        shape = RoundedCornerShape(50)
                    )
            )
            Slider(
                value = sliderPosition,
                onValueChange = onValueChange,
                valueRange = 0f..10f,
                steps = 0,
                modifier = Modifier.fillMaxWidth(),
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF2196F3),
                    activeTrackColor = Color.Transparent,
                    inactiveTrackColor = Color.Transparent
                ),
                thumb = {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color(0xFF2196F3), shape = CircleShape)
                    )
                }
            )

        }

    }
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("0", fontSize = 14.sp, color = Color.DarkGray)
        Text("10", fontSize = 14.sp, color = Color.DarkGray)
    }
}


@Preview(showBackground = true)
@Composable
fun FeelingScreenPreview() {
    val fakeUIState = AddictionDailyRecordUiState(
        isSecondEntryValid = true,
    )
    FeelingScreen(
        dailyRecordUiState = fakeUIState,
        onSaveClick = {}
    )
}