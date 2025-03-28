package com.example.coursesapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.R
import com.example.coursesapp.core.composable.CustomTextField
import com.example.coursesapp.home.items.CourseItem
import com.example.coursesapp.ui.theme.BasicGreen
import com.example.coursesapp.ui.theme.CoursesAppTheme
import com.example.coursesapp.ui.theme.DarkGrey

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            HeaderHome()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.weight(1f))
                DataFilterView()
            }

            val items = listOf("Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3")

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp), // Отступы между элементами
                state = rememberLazyListState()
            ) {
                items(items) {
                    CourseItem(title = it)
                }
            }

        }
    }
}

@Composable
fun HeaderHome() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        CustomTextField(
            value = "example@gmail.com",
            placeholder = "example@gmail.com",
            onValueChange = { /*viewModel.handleEvent(HomeScreenUiEvent.InputLogin(it))*/ },
            containerColor = DarkGrey,
            roundedCornerShape = RoundedCornerShape(28.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Email",
                    modifier = Modifier.size(20.dp)
                )
            }
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(56.dp) // Квадратная основа для круга
                .align(Alignment.CenterVertically)
                .background(
                    color = DarkGrey,
                    shape = CircleShape // Используем встроенную круглую форму
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Фильтры",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun DataFilterView(){
    Text(
        modifier = Modifier.padding(end = 4.dp),
        textAlign = TextAlign.End,
        text = "По дате добавления",
        color = MaterialTheme.colorScheme.primary
    )
    Icon(
        painter = painterResource(id = R.drawable.arrow_down_up),
        contentDescription = "По дате добавления",
        tint = BasicGreen,
        modifier = Modifier.size(15.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun HomeScreenPreview() {
    CoursesAppTheme {
        HomeScreen()
    }
}