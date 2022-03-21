package com.sleep.wetrade.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sleep.wetrade.R

val MontserratFamily = FontFamily(
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.montserrat_extra_light, FontWeight.ExtraLight),
    Font(R.font.montserrat_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.montserrat_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
    Font(R.font.montserrat_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_thin_italic, FontWeight.Thin, FontStyle.Italic),
)

val WeTradeTypography = Typography(
    defaultFontFamily = MontserratFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 40.sp,
        letterSpacing = 1.25.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 13.sp,
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        letterSpacing = 1.25.sp
    )
)