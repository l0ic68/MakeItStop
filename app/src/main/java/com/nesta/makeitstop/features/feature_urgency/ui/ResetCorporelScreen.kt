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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.TitleLarge
import com.nesta.makeitstop.ui.theme.materialSymbols

@Composable
fun ResetCorporelScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        TitleLarge("Reset corporel express")
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "20 pompes / squats / jumping jacks",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "sports_gymnastics",
            fontFamily = materialSymbols,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 160.sp,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(0.7f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0XFFb4ade8))
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ou contracte tous tes muscles 5 secondes avant de relâcher",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.urgency_senses_arrow_right_alt_icon),
                fontSize = 25.sp,
                fontFamily = materialSymbols,
                color = Color(0XFF868e9f),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Ca fait baisser l'excès d'adrénaline",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF868e9f),
                textAlign = TextAlign.Left
            )
        }


    }
}

@Preview
@Composable
fun ResetCorporelScreenPreview() {
    PreviewBackground {
        ResetCorporelScreen()
    }
}