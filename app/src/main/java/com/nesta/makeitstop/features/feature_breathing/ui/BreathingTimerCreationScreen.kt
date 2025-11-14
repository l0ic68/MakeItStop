package com.nesta.makeitstop.features.feature_breathing.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.core.ui.PreviewBackground
import com.nesta.makeitstop.core.ui.TitleLarge
import com.nesta.makeitstop.ui.theme.poppinFont

@Composable
fun BreathingTimerCreationScreen() {
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
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(name = "Inhale")
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(name = "Hold")
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(name = "Exhale")
        Spacer(Modifier.height(40.dp))
        EditBreathingRowComponent(name = "Cycles")

    }
}

@Composable
fun EditBreathingRowComponent(
    name:String = "Inhale"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround

    ){
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

            )

        Text(
            text = "3 ",
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,

            )

        Text(
            text = "> ",
            color = Color.White,
            fontFamily = poppinFont,
            fontSize = 24.sp,

            )
    }
}

@Preview
@Composable
fun PreviewBreathingTimerCreationScreen() {
    PreviewBackground {
        BreathingTimerCreationScreen()
    }
}