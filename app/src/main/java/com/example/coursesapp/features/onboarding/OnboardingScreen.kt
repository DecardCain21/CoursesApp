package com.example.coursesapp.features.onboarding

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
import com.example.coursesapp.R
import com.example.coursesapp.core.composable.CourseGreenButton
import com.example.coursesapp.ui.theme.CoursesAppTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
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
            text = stringResource(R.string.continue_word),
            buttonColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = MaterialTheme.colorScheme.tertiary,
            enabledTextColor = MaterialTheme.colorScheme.tertiary,
            isEnabled = false,
            onClick = {}
        )

    }

}

@Composable
private fun Header() {
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = stringResource(R.string.header_onboarding),
        color = MaterialTheme.colorScheme.tertiary
    )
}

@Composable
private fun ColumnScope.Logo() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .padding(top = 32.dp),
        painter = painterResource(id = R.drawable.courses),
        contentDescription = "Logo",
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun OnboardingScreen() {
    CoursesAppTheme {
        OnboardingScreen(modifier = Modifier)
    }
}