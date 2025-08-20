package com.nesta.makeitstop.ui.addiction

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.ui.theme.MakeItStopTheme
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.poppinFont
import com.nesta.makeitstop.ui.theme.titleColor

@Composable
fun CravingScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier) {
    Column( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        topBarTitle("Pause Refléxion", 36.sp)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            var firstAnswer by remember { mutableStateOf("")}
            var secondAnswer by remember { mutableStateOf("")}
            var thirdAnswer by remember { mutableStateOf("")}

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Avant de fumer, arrête toi deux minutes et pose toi ces questions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                GuiltItem(
                    question = stringResource(R.string.craving_first_sentence),
                    text = firstAnswer,
                    onValueChange = { firstAnswer = it }
                )
                GuiltItem(
                    question = stringResource(R.string.craving_second_sentence),
                    text = secondAnswer,
                    onValueChange = { secondAnswer = it }
                )
                GuiltItem(
                    question = stringResource(R.string.craving_third_sentence),
                    text = thirdAnswer,
                    onValueChange = { thirdAnswer = it }
                )

                var isButtonEnabled = false
                if (!firstAnswer.isEmpty() && !secondAnswer.isEmpty() && !thirdAnswer.isEmpty()) {
                    isButtonEnabled = true
                }

                Button(
                    onClick = onClick,
                    modifier = Modifier.padding(20.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(4.dp),
                    enabled = isButtonEnabled,
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
fun OnBoardingScreen() {
    var isDisplayed by remember { mutableStateOf(true) }

    if (!isDisplayed) {

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

@Preview(showBackground = true)
@Composable
fun CravinScreenPreview() {
    MakeItStopTheme {
        Surface()
        {
            CravingScreen(onClick = {})
        }
    }
}