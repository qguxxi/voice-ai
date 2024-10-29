package com.qguxxi.tapper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.ui.screen.signin.SignInScreen
import com.qguxxi.tapper.ui.screen.splash.SplashScreen

enum class Screen {
    HOME,
    SPLASH,
    SIGNIN
}

@Composable
fun TapperNavHost(
    navController: NavHostController
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SPLASH.name) {
        composable(route = Screen.SIGNIN.name) {
            SignInScreen()
        }
        composable(route = Screen.SPLASH.name) {
            SplashScreen(navController = navController)
        }
    }

}