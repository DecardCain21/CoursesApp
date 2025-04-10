package com.example.ui.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.ui.composable.CourseItem
import com.example.core.ui.composable.CourseTextField
import com.example.core.ui.theme.BasicGreen
import com.example.core.ui.theme.CoursesAppTheme
import com.example.core.ui.theme.DarkGrey
import com.example.features.courses.models.Course
import com.example.ui.R
import com.example.ui.state.HomeScreenState
import com.example.ui.state.HomeScreenUiEvent
import org.koin.androidx.compose.koinViewModel

@Composable
public fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        when (val currentSate = state) {
            is HomeScreenState.Data -> Data(
                state = currentSate,
                onSortByData = {
                    viewModel.handleEventHomeScreen(
                        HomeScreenUiEvent.SortByDate
                    )
                },
                clickOnBookmark = {
                    viewModel.handleEventHomeScreen(
                        HomeScreenUiEvent.FavoriteCourse(it)
                    )
                })

            is HomeScreenState.Empty -> Unit // TODO
            is HomeScreenState.Error -> Unit // TODO
            is HomeScreenState.Loading -> Unit // TODO
        }
    }
}

@Composable
private fun Data(
    state: HomeScreenState.Data,
    onSortByData: () -> Unit,
    clickOnBookmark: (Course) -> Unit
) {
    Column {
        HeaderHome()
        DataFilterView(onSortByData = onSortByData)
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
                    clickOnBookmark = { clickOnBookmark(course) }
                )
            }
        }

    }
}

@Composable
private fun HeaderHome() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        CourseTextField(
            value = "",
            placeholder = stringResource(R.string.home_placeholder_text_email),
            onValueChange = {},
            containerColor = DarkGrey,
            roundedCornerShape = RoundedCornerShape(28.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.CenterVertically)
                .background(
                    color = DarkGrey,
                    shape = CircleShape
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home_filter),
                contentDescription = "",
                tint = Color.White,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DataFilterView(onSortByData: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .combinedClickable(
                indication = null,
                onClick = { onSortByData() },
                interactionSource = remember { MutableInteractionSource() },
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(end = 4.dp),
            textAlign = TextAlign.End,
            text = stringResource(R.string.by_date_added),
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Icon(
            painter = painterResource(id = R.drawable.arrow_down_up),
            contentDescription = "",
            tint = BasicGreen,
            modifier = Modifier.size(15.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun HomeScreenPreview() {
    CoursesAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Data(
                state = HomeScreenState.Data(
                    listOf(
                        Course(
                            id = 1,
                            title = "123",
                            description = "Тестовое описание",
                            price = "999",
                            startDate = "12.03.2053",
                            isLiked = false,
                            publishDate = "12.03.2053",
                            rating = "10"
                        )
                    )
                ), onSortByData = {}, clickOnBookmark = {})
        }
    }
}
