package com.nesta.makeitstop

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.ui.theme.MakeItStopTheme
import com.nesta.makeitstop.ui.theme.PrimaryDark
import com.nesta.makeitstop.ui.theme.PrimaryWhite
import com.nesta.makeitstop.ui.theme.SecondaryDark

@Composable
fun GuiltItem(
    modifier: Modifier = Modifier ,
    question: String ,
    text: String ,
    onValueChange: (String) -> Unit
) {
    val interFont = FontFamily(
        Font(R.font.inter_font , FontWeight.Normal) ,
        Font(R.font.inter_bold , FontWeight.Bold) ,
        Font(R.font.inter_semi_bold , FontWeight.SemiBold) ,
        Font(R.font.inter_regular , FontWeight.Normal, FontStyle.Italic) ,
        Font(R.font.inter_italic_font , FontWeight.Normal, FontStyle.Italic)
    )

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = PrimaryWhite
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )) {
        Text(
            question,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            fontFamily = interFont,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            color = PrimaryDark,
            modifier = Modifier
                .paddingFromBaseline(bottom = 16.dp)
                .padding(16.dp)
        )
        OutlinedTextField(
            value = text,
            placeholder = {
                Text(
                    text = "Écris ta réponse...",
                    color = Color(0xFFA6A6A6),
                    style = TextStyle(
                        fontFamily = interFont,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp
                    )
                )
            },
            textStyle = TextStyle(
                fontFamily = interFont,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontSize = 14.sp),
            onValueChange = { onValueChange } ,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GuiltItemPreview() {
    GuiltItem(question = "Est-ce que j’en ai vraiment envie ?", text = "" , onValueChange = {}, modifier = Modifier.padding(16.dp))
}