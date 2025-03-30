package com.example.coursesapp.features.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.coursesapp.features.account.AccountScreen

const val ACCOUNT_ROUTE = "account"

fun NavGraphBuilder.accountScreen() {
    composable(route = ACCOUNT_ROUTE) {
        AccountScreen()
    }
}