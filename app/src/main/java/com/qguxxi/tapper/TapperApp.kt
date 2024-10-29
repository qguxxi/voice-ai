package com.qguxxi.tapper

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.navigation.TapperNavHost

@Composable
fun TapperApp(navController : NavHostController = rememberNavController()) {
    TapperNavHost(navController = navController)
}