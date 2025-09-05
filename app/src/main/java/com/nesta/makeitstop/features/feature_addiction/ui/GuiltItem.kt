package com.nesta.makeitstop.features.feature_addiction.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.ui.theme.PrimaryDark
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.interFont
import com.nesta.makeitstop.ui.theme.poppinFont

@Composable
fun GuiltItem(
    modifier: Modifier = Modifier,
    question: String,
    text: String,
    onValueChange: (String) -> Unit = {},
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        colors = CardDefaults.cardColors(containerColor = PrimaryWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                question,
                fontSize = 16.sp,
                fontFamily = poppinFont,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                color = PrimaryDark,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = text,
                onValueChange = onValueChange,
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(
                        text = "Écris ta réponse...",
                        color = Color(0xFF999999),
                        style = TextStyle(
                            fontFamily = interFont,
                            fontStyle = FontStyle.Italic,
                            fontSize = 14.sp,
                        )
                    )
                },
                textStyle = TextStyle(
                    fontFamily = interFont,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black,
                    fontSize = 14.sp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE0E0E0),
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    disabledBorderColor = Color.Transparent,
                    focusedContainerColor = Color(0xFFF7F7F7),
                    unfocusedContainerColor = Color(0xFFF7F7F7)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GuiltItemPreview() {
    //GuiltItem(question = "Est-ce que j’en ai vraiment envie ?", text = "" , onValueChange = {}, modifier = Modifier.padding(16.dp))
}