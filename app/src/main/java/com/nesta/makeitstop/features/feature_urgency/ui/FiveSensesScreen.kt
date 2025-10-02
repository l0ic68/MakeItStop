package com.nesta.makeitstop.features.feature_urgency.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.nesta.makeitstop.ui.theme.materialSymbols


@Composable
fun FiveSensesScreen() {
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
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.urgency_senses_title),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF),
            )
            Text(
                text = stringResource(R.string.urgency_senses_anchor),
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF)
            )
            Spacer(Modifier.height(45.dp))
            Text(
                text = stringResource(R.string.urgency_senses_confusion_burst),
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF)
            )
            Spacer(Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                FiveSenseRow(
                    icon = stringResource(R.string.urgency_senses_row_visibility_icon),
                    text = stringResource(R.string.urgency_senses_row_visibility_text)
                )

                FiveSenseRow(
                    icon = stringResource(R.string.urgency_senses_row_back_hand_icon),
                    text = stringResource(R.string.urgency_senses_row_back_hand_text)
                )

                FiveSenseRow(
                    icon = stringResource(R.string.urgency_senses_row_hearing_icon),
                    text = stringResource(R.string.urgency_senses_row_hearing_text)
                )

                FiveSenseRow(
                    icon = stringResource(R.string.urgency_senses_row_smell_icon),
                    text = stringResource(R.string.urgency_senses_row_smell_text)
                )
            }
            Spacer(Modifier.height(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.urgency_senses_row_smell_icon),
                    fontSize = 30.sp,
                    fontFamily = materialSymbols,
                    color = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = stringResource(R.string.urgency_senses_arrow_right_alt_text),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Left
                )
            }
        }

    }
}

@Composable
fun FiveSenseRow(
    icon: String,
    text: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        var checked by remember { mutableStateOf(false) }

        Text(
            text = icon,
            fontFamily = materialSymbols,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(0.1f)
        )
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color(0xFFE6ECFF),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.White,
                checkmarkColor = Color.Black,
                uncheckedColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth(0.1f)
        )
    }
}

@Composable
@Preview()
fun FiveSensesScreenPreview() {
    FiveSensesScreen()
}