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
fun StopMentalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        TitleLarge("Rituel «Stop Mental»")
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Quand tu sens la boucle de stress : \nDis mentalement \"Stop\" et lève la main comme un signal",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "back_hand",
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
            text = "Puis déplace ton attention volontairement vers une action très simple",
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
                fontSize = 30.sp,
                fontFamily = materialSymbols,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Boire un verre d'eau,\n marcher 30 secondes\n toucher un objet",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Left
            )
        }


    }
}

@Preview
@Composable
fun StopMentalPreview() {
    PreviewBackground {
        StopMentalScreen()
    }
}