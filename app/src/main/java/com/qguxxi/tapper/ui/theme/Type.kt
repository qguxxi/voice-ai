package com.qguxxi.tapper.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qguxxi.tapper.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Roboto"),
        fontProvider = provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Roboto"),
        fontProvider = provider,
    )
)

// Default Material 3 typography values
val baseline = Typography()

val TapperTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)

val figmaTypography = Typography(
    displayMedium = TextStyle(
        fontSize = 40.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFF5C5C5C),
    ),
    displayLarge =  TextStyle(
        fontSize = 96.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(700),
        color = Color(0xFF000000),
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(700),
        color = Color(0xFFFFFFFF),
    ),
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(500),
        color = Color(0xFFFFFFFF),
    ),

    bodyMedium = TextStyle(
        fontSize = 24.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(600),
        color = Color(0xFF5C5C5C),

    ),

    labelLarge = TextStyle(
        fontSize = 28.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(600),
        color = Color(0xFF000000),
    ),
    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(600),
        color = Color(0xFFFFFFFF),
    ),
    titleSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = bodyFontFamily,
        fontWeight = FontWeight(400),
        color = Color(0xFF000000),
        textAlign = TextAlign.Center,
    )
)

