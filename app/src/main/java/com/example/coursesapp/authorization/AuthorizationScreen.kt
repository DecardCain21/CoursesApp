package com.example.coursesapp.authorization

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.R
import com.example.coursesapp.core.composable.BasicGreenButton
import com.example.coursesapp.core.composable.CustomTextField
import com.example.coursesapp.ui.theme.BlueLight
import com.example.coursesapp.ui.theme.CoursesAppTheme
import com.example.coursesapp.ui.theme.DividerColor
import com.example.coursesapp.ui.theme.OrangeEndColor
import com.example.coursesapp.ui.theme.OrangeStartColor

@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    onForgotPasswordClick: () -> Unit = {},
    onPressButtonLeft: () -> Unit = {},
    onPressRight: () -> Unit = {},
    navigateToMainScreen: () -> Unit = {},
) {
    /*val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }*/

    /*LaunchedEffect(navEvent) {
        navEvent?.let {
            navigateToIntroductionScreen()
        }
    }*/
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Text(
                modifier = Modifier.padding(top = 100.dp),
                text = stringResource(R.string.enter),
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                modifier = Modifier.padding(top = 28.dp),
                text = stringResource(R.string.email),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
            //with(uiState) {
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                value = "example@gmail.com",
                placeholder = "example@gmail.com",
                onValueChange = { /*viewModel.handleEvent(HomeScreenUiEvent.InputLogin(it))*/ },
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(R.string.password),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp),
                value = stringResource(R.string.enter_password),
                placeholder = "123",
                onValueChange = { /*viewModel.handleEvent(HomeScreenUiEvent.InputLogin(it))*/ },
            )
            // }
            BasicGreenButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                text = stringResource(R.string.enter),
                onClick = { }
            )
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
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
                thickness = 1.dp,
                color = DividerColor
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    modifier = Modifier
                        .height(40.dp)
                        .width(156.dp)
                        .background(
                            color = BlueLight,
                            shape = RoundedCornerShape(30.dp)
                        ),
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource(R.drawable.vk),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(modifier = Modifier
                    .height(40.dp)
                    .width(156.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(OrangeEndColor, OrangeStartColor),
                            startY = 50f,
                            endY = 0f
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ), onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.odnoclass),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
            }


        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun OnboardingScreen() {
    CoursesAppTheme {
        AuthorizationScreen()
    }
}