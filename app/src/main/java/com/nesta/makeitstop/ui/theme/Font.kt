package com.nesta.makeitstop.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.nesta.makeitstop.R


val materialSymbols = FontFamily(
    Font(R.font.material_symbols_outlined_latin_500_normal, weight = FontWeight.Normal)
)
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


val nunitoFont = FontFamily(
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_semi_bold, FontWeight.SemiBold),
    Font(R.font.nunito_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.nunito_semi_bold_talic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nunito_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.nunito_medium_italic, FontWeight.Medium, FontStyle.Italic),
)