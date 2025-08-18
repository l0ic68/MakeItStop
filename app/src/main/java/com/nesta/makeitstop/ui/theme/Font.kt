package com.nesta.makeitstop.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.nesta.makeitstop.R

val interFont = FontFamily(
    Font(R.font.inter_font, FontWeight.Normal),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_italic_font, FontWeight.Normal, FontStyle.Italic)
)

val poppinFont = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_italic_font, FontWeight.Normal, FontStyle.Italic)
)