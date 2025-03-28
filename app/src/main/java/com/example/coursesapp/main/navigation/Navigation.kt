package com.example.coursesapp.main.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coursesapp.authorization.AuthorizationScreen
import com.example.coursesapp.authorization.navigation.AUTH_ROUTE
import com.example.coursesapp.home.HomeScreen
import com.example.coursesapp.home.navigation.HOME_ROUTE
import com.example.coursesapp.home.navigation.navigateToHomeScreen
import com.example.coursesapp.onboarding.OnboardingScreen
import com.example.coursesapp.onboarding.navigation.ONBOARD_ROUTE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    /*val items = listOf(
        BottomNavigationItem(
            title = "Главная",
            icon = Icons.Filled.Home,
        ),
        BottomNavigationItem(
            title = "Избранное",
            icon = Icons.Filled.Check,
        ),
        BottomNavigationItem(
            title = "Аккаунт",
            icon = Icons.Filled.Accessibility
        )
    )*/
    val noBottomBarScreens = listOf(ONBOARD_ROUTE, AUTH_ROUTE)

    Scaffold(
        bottomBar = {
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            if (currentRoute !in noBottomBarScreens) { // Показываем BottomBar, если не в списке
                NavigationBar(
                    modifier = Modifier.height(96.dp),
                    containerColor = MaterialTheme.colorScheme.primary,
                ) {
                    val items = listOf(
                        BottomNavigationItem(HOME_ROUTE, Icons.Default.Home, HOME_ROUTE),
                        BottomNavigationItem(AUTH_ROUTE, Icons.Default.Person, AUTH_ROUTE)
                    )

                    items.forEach { item ->
                        NavigationBarItem(
                            selected = currentRoute == item.route,
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
                                indicatorColor = MaterialTheme.colorScheme.tertiary
                            ),
                            alwaysShowLabel = false,
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
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AUTH_ROUTE,
            modifier = Modifier.padding(innerPadding)
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
    val route: String
)