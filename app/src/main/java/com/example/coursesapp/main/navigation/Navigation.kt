package com.example.coursesapp.main.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coursesapp.R
import com.example.coursesapp.features.authorization.ui.AuthorizationScreen
import com.example.coursesapp.features.authorization.navigation.AUTH_ROUTE
import com.example.coursesapp.features.home.ui.HomeScreen
import com.example.coursesapp.features.home.navigation.HOME_ROUTE
import com.example.coursesapp.features.home.navigation.navigateToHomeScreen
import com.example.coursesapp.features.onboarding.OnboardingScreen
import com.example.coursesapp.features.onboarding.navigation.ONBOARD_ROUTE
import com.example.coursesapp.ui.theme.BasicGreen
import com.example.coursesapp.ui.theme.BasicGrey
import com.example.coursesapp.ui.theme.DarkGrey
import com.example.coursesapp.ui.theme.StrokeColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    val noBottomBarScreens = listOf(ONBOARD_ROUTE, AUTH_ROUTE)

    Scaffold(
        bottomBar = {
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            if (currentRoute !in noBottomBarScreens) {
                NavigationBar(
                    modifier = Modifier
                        .wrapContentSize()
                        .drawWithCache {
                            val strokeWidth = 1.dp.toPx()
                            onDrawWithContent {
                                drawContent()
                                drawLine(
                                    color = StrokeColor,
                                    start = Offset(0f, 0f),
                                    end = Offset(size.width, 0f),
                                    strokeWidth = strokeWidth
                                )
                            }
                        },
                    containerColor = DarkGrey,
                ) {
                    val items = listOf(
                        BottomNavigationItem(
                            title = "Главная",
                            icon = ImageVector.vectorResource(R.drawable.ic_home),
                            route = HOME_ROUTE,
                            titleColor = BasicGreen
                        ),
                        BottomNavigationItem(
                            title = "Избранное",
                            icon = ImageVector.vectorResource(R.drawable.ic_bookmarkbig),
                            route = AUTH_ROUTE
                        ),
                        BottomNavigationItem(
                            title = "Аккаунт",
                            icon = ImageVector.vectorResource(R.drawable.ic_account),
                            route = ""
                        )
                    )

                    items.forEach { item ->
                        NavigationBarItem(
                            modifier = Modifier,
                            selected = currentRoute == item.route,
                            label = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = item.titleColor
                                )
                            },
                            onClick = {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = BasicGrey,
                                selectedIconColor = BasicGreen,
                            ),
                            alwaysShowLabel = true,
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.route
                                )
                            }
                        )
                    }
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AUTH_ROUTE,
            modifier = Modifier
        ) {
            composable(AUTH_ROUTE) { AuthorizationScreen(navigateToMainScreen = { navController.navigateToHomeScreen() }) }
            composable(HOME_ROUTE) { HomeScreen() }
            composable(ONBOARD_ROUTE) { OnboardingScreen() }
        }
    }

}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val titleColor: Color = Color.White
)