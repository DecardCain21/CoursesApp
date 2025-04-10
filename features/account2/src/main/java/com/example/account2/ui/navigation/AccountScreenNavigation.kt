package com.example.account2.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.account2.ui.AccountScreen

public const val ACCOUNT_ROUTE: String = "account"

public fun NavGraphBuilder.accountScreen() {
    composable(route = ACCOUNT_ROUTE) {
        AccountScreen()
    }
}
