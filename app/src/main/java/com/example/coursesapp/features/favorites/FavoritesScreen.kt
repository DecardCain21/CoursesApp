package com.example.coursesapp.features.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.R
import com.example.coursesapp.features.home.domain.items.CourseItem
import com.example.coursesapp.ui.theme.CoursesAppTheme

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Header()
            val items = listOf("Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
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
private fun Header() {
    Text(
        modifier = Modifier.padding(top = 56.dp),
        text = stringResource(R.string.favorites),
        fontSize = 22.sp,
        color = MaterialTheme.colorScheme.tertiary
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
fun FavoriteScreen() {
    CoursesAppTheme {
        FavoritesScreen()
    }
}