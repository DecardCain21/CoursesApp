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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coursesapp.R
import com.example.coursesapp.features.account.ui.navigation.ACCOUNT_ROUTE
import com.example.coursesapp.features.account.ui.navigation.accountScreen
import com.example.coursesapp.features.authorization.ui.navigation.AUTH_ROUTE
import com.example.coursesapp.features.authorization.ui.navigation.authorizationScreen
import com.example.coursesapp.features.authorization.ui.navigation.navigateToAuthorizationScreen
import com.example.coursesapp.features.favorites.ui.navigation.FAVORITES_ROUTE
import com.example.coursesapp.features.favorites.ui.navigation.favoritesScreen
import com.example.coursesapp.features.home.ui.navigation.HOME_ROUTE
import com.example.coursesapp.features.home.ui.navigation.homeScreen
import com.example.coursesapp.features.home.ui.navigation.navigateToHomeScreen
import com.example.coursesapp.features.onboarding.navigation.ONBOARD_ROUTE
import com.example.coursesapp.features.onboarding.navigation.onboardingScreen
import com.example.coursesapp.ui.theme.BasicGreen
import com.example.coursesapp.ui.theme.BasicGrey
import com.example.coursesapp.ui.theme.DarkGrey
import com.example.coursesapp.ui.theme.StrokeColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(isAuthenticated: Boolean) {
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
                            title = stringResource(R.string.title_home),
                            icon = ImageVector.vectorResource(R.drawable.ic_home),
                            route = HOME_ROUTE,
                            titleColor = BasicGreen
                        ),
                        BottomNavigationItem(
                            title = stringResource(R.string.title_favorites),
                            icon = ImageVector.vectorResource(R.drawable.ic_bookmarkbig),
                            route = FAVORITES_ROUTE
                        ),
                        BottomNavigationItem(
                            title = stringResource(R.string.title_account),
                            icon = ImageVector.vectorResource(R.drawable.ic_account),
                            route = ACCOUNT_ROUTE
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
                                disabledTextColor = Color.White,
                                selectedTextColor = BasicGreen,
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
            startDestination = if (isAuthenticated) AUTH_ROUTE else ONBOARD_ROUTE,
            modifier = Modifier
        ) {
            authorizationScreen(navigateToMainScreen = { navController.navigateToHomeScreen() })
            homeScreen()
            onboardingScreen(navigateToAuthorizationScreen = { navController.navigateToAuthorizationScreen() })
            accountScreen()
            favoritesScreen()
        }
    }

}

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val titleColor: Color = Color.White
)
