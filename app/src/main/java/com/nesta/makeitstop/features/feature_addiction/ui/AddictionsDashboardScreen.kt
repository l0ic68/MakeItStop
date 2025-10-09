package com.nesta.makeitstop.features.feature_addiction.ui

import android.util.Log.d
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionDetails
import com.nesta.makeitstop.features.feature_addiction.data.viewmodel.AddictionUiState
import com.nesta.makeitstop.features.feature_addiction.data.model.Addiction
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.materialSymbols
import com.nesta.makeitstop.ui.theme.nunitoFont
import com.nesta.makeitstop.ui.theme.poppinFont

@Composable
fun AddictionsDashboardScreen(
    title: String,
    addictionCount: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFFE6ECFF)
        )

        Column(
            modifier = Modifier.padding(20.dp)

        ) {

            Text(
                text = "Compteur : $addictionCount",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFFE6ECFF),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.5f),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "alarm",
                        fontFamily = materialSymbols,
                        fontSize = 30.sp,
                        color = Color(0xFFc2c1f8),
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "12 jours sans consommation ",
                        fontSize = 15.sp,
                        fontFamily = poppinFont,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFE6ECFF),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "mode_heat",
                        fontFamily = materialSymbols,
                        fontSize = 30.sp,
                        color = Color(0xFFc2c1f8),
                    )
                    Spacer(Modifier.width(8.dp))

                    Text(
                        text = "Meilleure série : \n21 jours",
                        fontSize = 15.sp,
                        fontFamily = poppinFont,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFE6ECFF),
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "double_arrow",
                    fontFamily = materialSymbols,
                    fontSize = 30.sp,
                    color = Color(0xFFc2c1f8),
                )
                Spacer(Modifier.width(8.dp))

                Text(
                    text = "Dernière consommation : 4 sept",
                    fontSize = 15.sp,
                    fontFamily = poppinFont,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFE6ECFF),
                )
            }
            Spacer(Modifier.height(8.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "test")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddictionsDashboardScreenPreview() {
    val fakeState = remember { mutableStateOf(AddictionUiState(showDialog = false)) }

    // fake list
    val fakeList = listOf(
        Addiction(id = 1, name = "Monster Energy"),
        Addiction(id = 2, name = "Café")
    )
    PreviewBackground {
        AddictionsDashboardScreen(
            title = "Monster Energy",
            addictionCount = 5,
            modifier = Modifier
        )
    }

}