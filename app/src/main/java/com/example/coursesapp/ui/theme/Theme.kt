package com.example.coursesapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorScheme = darkColorScheme(
    // Основной цвет приложения
    // (Обычно используется для главных элементов интерфейса, таких как AppBar, кнопки и т. д.)
    primary = BasicGreen,

    // Вспомогательный цвет
    // (Используется для менее важных элементов интерфейса, например, индикаторов)
    secondary = LightGrey,

    // Часто применяется для специальных акцентов, выделений или поддерживающих декоративных элементов
    tertiary = White,

    // Цвет фона приложения
    background = Black,

    // Применяется для фона отдельных компонентов, таких как карточки (Card),
    // модальные окна и т. д.
    // Отличается от background, поскольку представляет фоновую поверхность "над" основным фоном.
    surface = Grey,

    //
    outline = OutlineLightGrey,

    //
    onSurfaceVariant = LightGrey,

    // Цвет текста и иконок, которые отображаются поверх элемента с primary цветом
    onPrimary = Color.Black,

    //
    surfaceContainerLow = White,

    // Цвет текста и иконок поверх secondary
    onSecondary = Grey,

    // Цвет текста и иконок поверх tertiary
    onTertiary = White,

    // Цвет текста и иконок поверх background
    // (Используется для текста, отображаемого на основном фоне приложения)
    onBackground = White,

    // Цвет текста и иконок поверх surface
    // (Применяется для текста на карточках, диалоговых окнах и других подобных поверхностях)
    onSurface = Black,
)

private val LightColorScheme = lightColorScheme(
    // Основной цвет приложения
    // (Обычно используется для главных элементов интерфейса, таких как AppBar, кнопки и т. д.)
    primary = BasicGreen,

    // Вспомогательный цвет
    // (Используется для менее важных элементов интерфейса, например, индикаторов)
    secondary = LightGrey,

    // Часто применяется для специальных акцентов, выделений или поддерживающих декоративных элементов
    tertiary = White,

    // Цвет фона приложения
    background = Black,

    // Применяется для фона отдельных компонентов, таких как карточки (Card),
    // модальные окна и т. д.
    // Отличается от background, поскольку представляет фоновую поверхность "над" основным фоном.
    surface = Grey,

    //
    outline = OutlineLightGrey,

    //
    onSurfaceVariant = LightGrey,

    // Цвет текста и иконок, которые отображаются поверх элемента с primary цветом
    onPrimary = White,

    //
    surfaceContainerLow = Color.White,

    // Цвет текста и иконок поверх secondary
    onSecondary = Grey,

    // Цвет текста и иконок поверх tertiary
    onTertiary = White,

    // Цвет текста и иконок поверх background
    // (Используется для текста, отображаемого на основном фоне приложения)
    onBackground = Color.White,

    // Цвет текста и иконок поверх surface
    // (Применяется для текста на карточках, диалоговых окнах и других подобных поверхностях)
    onSurface = Black,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CoursesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}