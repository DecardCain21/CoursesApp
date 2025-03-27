package com.example.coursesapp.core.composable


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.ui.theme.CoursesAppTheme

@Composable
fun BasicGreenButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    enabledTextColor: Color = MaterialTheme.colorScheme.tertiary,
    disabledTextColor: Color = MaterialTheme.colorScheme.tertiary,
    isEnabled: Boolean = true
) {

    Button(
        modifier = modifier.fillMaxWidth()/*.height(40.dp)*/,
        onClick = onClick,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(30.dp),
        contentPadding = PaddingValues(top = 18.dp, bottom = 18.dp),
        content = {
            Text(
                text = text,
                fontSize = 20.sp,
                color =
                if (isEnabled) {
                    enabledTextColor
                } else {
                    disabledTextColor
                }

            )
        }
    )
}

@Preview
@Composable
private fun BasicButtonPreview() {
    CoursesAppTheme {
        BasicGreenButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Кнопка",
            onClick = { }
        )
    }
}