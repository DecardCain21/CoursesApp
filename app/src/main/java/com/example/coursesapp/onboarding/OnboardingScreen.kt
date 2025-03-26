package com.example.coursesapp.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.R
import com.example.coursesapp.core.composable.BasicGreenButton
import com.example.coursesapp.ui.theme.CoursesAppTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 100.dp),
            text = "Тысячи курсов \nв одном месте",
            color = MaterialTheme.colorScheme.tertiary
        )
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp),
            painter = painterResource(id = R.drawable.courses),
            contentDescription = "Logo",
        )
        Spacer(modifier = Modifier.weight(1f))
        BasicGreenButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = "Продолжить",
            buttonColor = MaterialTheme.colorScheme.primary,
            disabledTextColor = MaterialTheme.colorScheme.tertiary,
            enabledTextColor = MaterialTheme.colorScheme.tertiary,
            isEnabled = false,
            onClick = {}
        )

    }

}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun OnboardingScreen() {
    CoursesAppTheme {
        OnboardingScreen(modifier = Modifier)
    }
}