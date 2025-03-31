package com.example.coursesapp.features.favorites.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.coursesapp.R
import com.example.coursesapp.core.ui.composable.CourseItem
import com.example.coursesapp.features.favorites.ui.state.FavoritesScreenState
import com.example.coursesapp.ui.theme.CoursesAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoritesScreenViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Column {
            Header()
            when (val currentState = state) {
                is FavoritesScreenState.Data -> {
                    Data(state = currentState)
                }
            }
        }
    }
}

@Composable
private fun Data(
    state: FavoritesScreenState.Data
) {
    Column {
        Header()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = rememberLazyListState()
        ) {
            items(state.courses) { course ->
                CourseItem(
                    title = course.title,
                    description = course.description,
                    clickOnBookmark = {})
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
