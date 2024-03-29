//import androidx.compose.material3.Typography
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import com.example.pokemon_api.R
//
//// Set of Material typography styles to start with
//object AppFont {
//    private val pokemonFontFamily = FontFamily(
//        Font(R.font.press_start_2p, FontWeight.Normal),
//        Font(R.font.press_start_2p, FontWeight.Bold)
//    )
//
//    val Typography = Typography(
//        displayLarge = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        displayMedium = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        displaySmall = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//
//        headlineLarge = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        headlineMedium = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        headlineSmall = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//
//        titleLarge = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        titleMedium = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        titleSmall = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//
//        bodyLarge = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        bodyMedium = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        bodySmall = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//
//        labelLarge = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        labelMedium = TextStyle(
//            fontFamily = pokemonFontFamily
//        ),
//        labelSmall = TextStyle(
//            fontFamily = pokemonFontFamily
//        )
//    )
//}


package com.example.pokemon_api.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.pokemon_api.R

// Set of Material typography styles to start with
object AppFont {
    private val pokemonFontFamily = FontFamily(
        Font(R.font.press_start_2p, FontWeight.Normal),
        Font(R.font.press_start_2p, FontWeight.Bold)
    )

    private val defaultTypography: Typography = Typography()
    val Typography = Typography(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = pokemonFontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = pokemonFontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = pokemonFontFamily),

        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = pokemonFontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = pokemonFontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = pokemonFontFamily),

        titleLarge = defaultTypography.titleLarge.copy(fontFamily = pokemonFontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = pokemonFontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = pokemonFontFamily),

        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = pokemonFontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = pokemonFontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = pokemonFontFamily),

        labelLarge = defaultTypography.labelLarge.copy(fontFamily = pokemonFontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = pokemonFontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = pokemonFontFamily)
    )
}

/* Other default text styles to override
titleLarge = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp
),
labelSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)*/