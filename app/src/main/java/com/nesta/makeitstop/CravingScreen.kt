package com.nesta.makeitstop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.tutorial.WellnessScreen
import com.nesta.makeitstop.ui.theme.AppBackground
import com.nesta.makeitstop.ui.theme.MakeItStopTheme
import com.nesta.makeitstop.ui.theme.PrimaryDark

@Composable
fun CravingScreen(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.padding(top = 40.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            topBarTitle()
            var isDisplayed by remember { mutableStateOf(true) }

            if (!isDisplayed) {
                Button(
                    onClick = { isDisplayed = false }
                ) {
                    Text("J'en ai envie")
                }
            }
            val firstAnswer = ""
            val secondAnswer = ""
            val thirdAnswer = ""
            if (isDisplayed) {
                GuiltItem(
                    question = stringResource(R.string.craving_first_sentence),
                    text = firstAnswer,
                    onValueChange = {},)
                GuiltItem(
                    question = stringResource(R.string.craving_second_sentence),
                    text = secondAnswer,
                    onValueChange = {})
                GuiltItem(
                    question = stringResource(R.string.craving_third_sentence),
                    text = thirdAnswer,
                    onValueChange = {})
            }
        }
    }
}

@Composable
fun topBarTitle(modifier: Modifier = Modifier) {

    val interFont = FontFamily(
        Font(R.font.inter_font, FontWeight.Normal),
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_italic_font, FontWeight.Normal, FontStyle.Italic)
    )

    Text(
        text = "Pause Réflexion",
        fontFamily = interFont,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        color = PrimaryDark,
        modifier = Modifier.paddingFromBaseline(bottom = 16.dp),
        fontSize = 22.sp,
    )
}

@Preview
@Composable
fun CravinScreenPreview() {
    MakeItStopTheme {
        CravingScreen()
    }
}