package com.nesta.makeitstop.core.ui

import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.nesta.makeitstop.R
import com.nesta.makeitstop.ui.theme.materialSymbols
import com.nesta.makeitstop.ui.theme.nunitoFont

@Composable
fun TitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE6ECFF),
    fontSize: TextUnit = 28.sp,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        fontFamily = nunitoFont,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun TextIcon(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE6ECFF),
    fontSize: TextUnit = 16.sp,
    textAlign: TextAlign = TextAlign.Left
) {
    Text(
        text = text,
        fontFamily = materialSymbols,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}