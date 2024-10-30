package com.qguxxi.tapper.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.ui.screen.permission.CameraPerScreen
import com.qguxxi.tapper.ui.screen.permission.NfcPerScreen
import com.qguxxi.tapper.ui.screen.permission.PreHomeScreen
import com.qguxxi.tapper.ui.screen.signin.SignInScreen
import com.qguxxi.tapper.ui.screen.splash.SplashScreen

enum class Screen {
    HOME,
    SPLASH,
    SIGNIN,
    PREHOME,
    NFC,
    CAMERAPER,
    READEXTERNAL,
    NOTIFICATION,
}

@Composable
fun TapperNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.SPLASH.name) {
        composable(route = Screen.SPLASH.name) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.SIGNIN.name) {
            SignInScreen()
        }
        composable(route = Screen.HOME.name) {
            // HomeScreen()
        }
        composable(route = Screen.PREHOME.name) {
            PreHomeScreen()
        }
        composable(route = Screen.NFC.name) {
            NfcPerScreen()
        }
        composable(route = Screen.CAMERAPER.name) {
            CameraPerScreen()
        }
    }

}