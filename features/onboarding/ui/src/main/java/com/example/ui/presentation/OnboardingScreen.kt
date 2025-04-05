package com.example.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.ui.composable.CourseGreenButton
import com.example.core.ui.theme.CoursesAppTheme
import com.example.ui.R

import org.koin.androidx.compose.koinViewModel

@Composable
public fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navigateToAuthorizationScreen: () -> Unit,
    viewModel: OnBoardingScreenViewModel = koinViewModel()
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Logo()
        Spacer(modifier = Modifier.weight(1f))
        CourseGreenButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            text = "321"/*stringResource(R.string.onboarding_continue_word)*/,
            buttonColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = MaterialTheme.colorScheme.tertiary,
            enabledTextColor = MaterialTheme.colorScheme.tertiary,
            isEnabled = true,
            onClick = {
                viewModel.setAuth()
                navigateToAuthorizationScreen()
            }
        )

    }

}

@Composable
private fun Header() {
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = "123"/*stringResource(R.string.onboarding_header_onboarding)*/,
        color = MaterialTheme.colorScheme.tertiary
    )
}

@Composable
private fun ColumnScope.Logo() {
    /*Image(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .padding(top = 32.dp),
        painter = painterResource(id = R.drawable.onboarding_courses),
        contentDescription = "",
    )*/
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun OnboardingScreen() {
    CoursesAppTheme {
        OnboardingScreen(modifier = Modifier, navigateToAuthorizationScreen = {})
    }
}
