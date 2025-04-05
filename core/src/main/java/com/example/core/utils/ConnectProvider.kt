package com.example.core.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.core.api.AppContext


public fun getConnected(appContext: AppContext): Boolean {
    val connectivityManager = appContext
        .getAppContext()
        .getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return if (capabilities != null) {
        with(capabilities) {
            when {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    } else {
        false
    }
}