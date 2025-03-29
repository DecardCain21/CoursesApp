package com.example.coursesapp.home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coursesapp.R
import com.example.coursesapp.ui.theme.BasicGreen
import com.example.coursesapp.ui.theme.CoursesAppTheme
import com.example.coursesapp.ui.theme.DarkGrey
import com.example.coursesapp.ui.theme.Glass
import com.example.coursesapp.ui.theme.WhiteDescription

@Composable
fun CourseItem(
    modifier: Modifier = Modifier,
    title: String = "Название курса",
    description: String = "Освойте backend-разработку \nи программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
    image: Painter = painterResource(R.drawable.filter), // Замените на ваш ресурс
    icon: @Composable () -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = DarkGrey,
        ),
        modifier = Modifier
            .fillMaxWidth()
             // Увеличил высоту для контента
    ) {
        Column(modifier = Modifier.background(color = DarkGrey)) {
            // Верхняя часть с изображением
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp)
            ) {
                HeaderItem()
                Box(modifier = Modifier.align(Alignment.BottomStart)) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 8.dp, bottom = 8.dp)
                    ) {
                        //Рейтинг
                        RatingBadge()
                        Spacer(modifier = Modifier.padding(4.dp))
                        //Дата
                        DateBadge(day = "22", month = "Мая", year = "2024")
                    }
                }

                // Иконка в правом верхнем углу
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp, end = 8.dp)
                ) {
                    FavoriteIcon()
                }
            }
            // Нижняя часть с текстом
            BodyItem(
                "Java-разработчик с нуля",
                "Освойте backend-разработку \nи программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании."
            )
        }
    }
}

@Composable
fun HeaderItem() {
    Surface(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.cover_1),
            contentDescription = "Изображение курса",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun BodyItem(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodyMedium,
            color = WhiteDescription.copy(alpha = 0.7f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "999P",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Подробнее",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    color = BasicGreen
                )
                Icon(
                    modifier = Modifier.padding(start = 2.dp),
                    painter = painterResource(R.drawable.arrow_right),
                    contentDescription = "Подробнее",
                    tint = BasicGreen
                )
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun FavoriteIcon() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .background(
                color = Glass,
                shape = RoundedCornerShape(20.dp), // Используем встроенную круглую форму
            )
            .size(28.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.bookmark),
            contentDescription = "Фильтры",
            tint = Color.White,
        )
    }
}

@Composable
fun RatingBadge() {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Glass,
        modifier = Modifier
            .wrapContentSize()

    ) {
        Row(
            modifier = Modifier.background(color = Glass),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(start = 6.dp),
                painter = painterResource(R.drawable.star),
                contentDescription = "Подробнее",
                tint = BasicGreen
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 6.dp),
                text = "4.9",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun DateBadge(
    modifier: Modifier = Modifier,
    day: String = "22",
    month: String = "Мая",
    year: String = "2024",
    textColor: Color = MaterialTheme.colorScheme.tertiary,
    backgroundColor: Color = Glass
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        modifier = modifier.wrapContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            DateText(
                text = day,
                modifier = Modifier.padding(end = 2.dp),
                color = textColor
            )
            DateText(
                text = month,
                modifier = Modifier.padding(horizontal = 2.dp),
                color = textColor
            )
            DateText(
                text = year,
                modifier = Modifier.padding(start = 2.dp),
                color = textColor
            )
        }
    }
}

@Composable
private fun DateText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 12.sp,
        color = color,
        modifier = modifier
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF141218)
@Composable
private fun CourseItemPreview() {
    CoursesAppTheme {
        CourseItem()
    }
}