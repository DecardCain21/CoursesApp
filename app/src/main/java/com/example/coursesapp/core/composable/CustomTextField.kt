package com.example.coursesapp.core.composable

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.ui.theme.BasicGrey
import com.example.coursesapp.ui.theme.BasicGreyText
import com.example.coursesapp.ui.theme.CoursesAppTheme

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text
) {

    var isFocused by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is FocusInteraction.Focus -> isFocused = true
                is FocusInteraction.Unfocus -> isFocused = false
            }
        }
    }

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 20) {
                onValueChange(newValue)
            }
        },
        interactionSource = interactionSource,
        singleLine = true,
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 16.sp
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = BasicGrey,
            unfocusedContainerColor = BasicGrey,
            disabledContainerColor = BasicGrey
        ),
        shape = RoundedCornerShape(30.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        placeholder = {
            Text(
                text = placeholder,
                color = BasicGreyText,
                fontSize = 14.sp
            )
        }
    )
}

@Preview
@Composable
private fun PreviewCustomTextField() {
    CoursesAppTheme {
        CustomTextField(
            onValueChange = {},
            placeholder = "example@gmail.com"
        )
    }
}