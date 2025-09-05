package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordDetails
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDailyRecordUiState
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.poppinFont
import com.nesta.makeitstop.ui.theme.titleColor

@Composable
fun CravingScreen(
    onClick: () -> Unit,
    dailyRecordUiState: AddictionDailyRecordUiState,
    onDailyRecordValueChange: (AddictionDailyRecordDetails) -> Unit,
    modifier: Modifier = Modifier) {
    Column( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        topBarTitle("Pause Réflexion", 36.sp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Avant de ${dailyRecordUiState.addictionDailyRecordDetails.addiction}, arrête toi deux minutes et pose toi ces questions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                GuiltItem(
                    question = stringResource(R.string.craving_first_sentence),
                    text = dailyRecordUiState.addictionDailyRecordDetails.firstAnswer,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(firstAnswer = it)
                        )
                    }
                )
                GuiltItem(
                    question = stringResource(R.string.craving_second_sentence),
                    text = dailyRecordUiState.addictionDailyRecordDetails.secondAnswer,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(secondAnswer = it)
                        )
                    }
                )
                GuiltItem(
                    question = stringResource(R.string.craving_third_sentence),
                    text = dailyRecordUiState.addictionDailyRecordDetails.thirdAnswer,
                    onValueChange = {
                        onDailyRecordValueChange(
                            dailyRecordUiState.addictionDailyRecordDetails.copy(thirdAnswer = it)
                        )
                    }
                )


                Button(
                    onClick = onClick,
                    modifier = Modifier.padding(20.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(4.dp),
                    enabled = dailyRecordUiState.isFirstEntryValid,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = PrimaryWhite,
                        containerColor = Color(0xFF4CA77D),
                    )
                ) {
                    Text(
                        text = "Valider ma décision",
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
fun topBarTitle(title:String, size:TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontFamily = poppinFont,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        color = titleColor,
        modifier = Modifier
            .paddingFromBaseline(bottom = 16.dp),
        fontSize = size,
    )
}
