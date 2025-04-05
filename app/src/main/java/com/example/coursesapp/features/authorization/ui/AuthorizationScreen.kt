package com.example.coursesapp.features.authorization.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coursesapp.R
import com.example.core.ui.composable.CourseGreenButton
import com.example.core.ui.composable.CourseTextField
import com.example.core.ui.extantions.isCyrillic
import com.example.core.ui.extantions.isValidEmail
import com.example.coursesapp.features.authorization.ui.state.AuthorizationScreenState
import com.example.coursesapp.features.authorization.ui.state.AuthorizationScreenUiEvent
import com.example.core.ui.theme.BlueLight
import com.example.core.ui.theme.CoursesAppTheme
import com.example.core.ui.theme.DividerColor
import com.example.core.ui.theme.OrangeEndColor
import com.example.core.ui.theme.OrangeStartColor
import org.koin.androidx.compose.koinViewModel

@Composable
public fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    navigateToMainScreen: () -> Unit = {},
    viewModel: AuthorizationViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Header()
            EmailTextInput(
                state = uiState,
                onValueChange = { newValue ->
                    viewModel.handleEvent(AuthorizationScreenUiEvent.InputLogin(newValue))
                },
                isEmailAttempt = { newValue ->
                    viewModel.handleEvent(
                        AuthorizationScreenUiEvent.EnterEnabled(
                            newValue
                        )
                    )
                }
            )
            PasswordTextInput(
                state = uiState,
                onValueChange = { newValue ->
                    viewModel.handleEvent(AuthorizationScreenUiEvent.InputPassword(newValue))
                })
            CourseGreenButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                text = stringResource(R.string.enter),
                isEnabled = uiState.enterEnabled,
                onClick = { navigateToMainScreen() }
            )
            OptionsView()
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                thickness = 1.dp,
                color = DividerColor
            )
            Body()
        }
    }
}

@Composable
private fun Header() {
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = stringResource(R.string.enter),
        fontSize = 36.sp,
        color = MaterialTheme.colorScheme.tertiary
    )
}

@Composable
private fun EmailTextInput(
    state: AuthorizationScreenState,
    onValueChange: (String) -> Unit,
    isEmailAttempt: (Boolean) -> Unit
) {

    Text(
        modifier = Modifier.padding(top = 28.dp),
        text = stringResource(R.string.email),
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.tertiary
    )
    CourseTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        value = state.inputValueLogin,
        placeholder = stringResource(R.string.placeholder_text_email),
        onValueChange = { newValue ->
            val filteredValue = newValue.filter {
                it.isLetter() && !it.isCyrillic() || it.isDigit() || "@._-".contains(it)
            }
            onValueChange(filteredValue)
            if (newValue.isValidEmail()) {
                isEmailAttempt(newValue.isValidEmail())
            }
        },
    )

}

@Composable
private fun PasswordTextInput(state: AuthorizationScreenState, onValueChange: (String) -> Unit) {
    Text(
        modifier = Modifier.padding(top = 16.dp),
        text = stringResource(R.string.password),
        fontSize = 18.sp,
        color = MaterialTheme.colorScheme.tertiary
    )
    CourseTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        value = state.inputValuePassword,
        placeholder = stringResource(R.string.placeholder_text_password),
        onValueChange = { newValue -> onValueChange(newValue) },
    )
}

@Composable
private fun OptionsView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.no_account),
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = stringResource(R.string.registration),
            color = MaterialTheme.colorScheme.primary
        )
    }
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(R.string.forgot_password),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
private fun SocialAuthButton(
    modifier: Modifier = Modifier,
    iconPainter: Painter,
    onClick: () -> Unit,
    backgroundColor: Color = BlueLight,
    gradientColors: List<Color>? = null,
    iconTint: Color = Color.White,
    contentDescription: String? = null
) {
    IconButton(
        modifier = modifier
            .height(40.dp)
            .width(156.dp)
            .background(
                brush = gradientColors?.let {
                    Brush.verticalGradient(
                        colors = it,
                        startY = 50f,
                        endY = 0f
                    )
                } ?: backgroundColor.toBrush(),
                shape = RoundedCornerShape(30.dp)
            ),
        onClick = onClick
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = contentDescription,
            tint = iconTint
        )
    }
}

public fun Color.toBrush(): Brush {
    return Brush.verticalGradient(
        colors = listOf(this, this),
        startY = 0f,
        endY = 0f
    )
}

@Composable
private fun Body() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        SocialAuthButton(
            modifier = Modifier,
            backgroundColor = BlueLight,
            iconPainter = painterResource(R.drawable.vk),
            contentDescription = "",
            iconTint = Color.White,
            onClick = {}
        )
        Spacer(modifier = Modifier.width(16.dp))
        SocialAuthButton(
            modifier = Modifier,
            gradientColors = listOf(OrangeEndColor, OrangeStartColor),
            iconPainter = painterResource(R.drawable.odnoclass),
            contentDescription = "",
            iconTint = Color.White,
            onClick = {}
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun OnboardingScreen() {
    CoursesAppTheme {
        AuthorizationScreen()
    }
}
