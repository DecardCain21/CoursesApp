package com.example.coursesapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.coursesapp.authorization.navigation.AUTH_ROUTE
import com.example.coursesapp.authorization.navigation.authorizationScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTH_ROUTE
    ) {
        authorizationScreen { /*toMain*/}
    }
}