package com.qguxxi.tapper.navigation

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.ui.screen.permission.CameraPerScreen
import com.qguxxi.tapper.ui.screen.permission.NfcPerScreen
import com.qguxxi.tapper.ui.screen.permission.NotificationPerScreen
import com.qguxxi.tapper.ui.screen.permission.PreHomeScreen
import com.qguxxi.tapper.ui.screen.signin.SignInScreen
import com.qguxxi.tapper.ui.screen.splash.SplashScreen
import com.qguxxi.tapper.untils.google.GoogleSignInViewModel

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
    activity: Activity,
    navController: NavHostController = rememberNavController(),
) {
    // Khởi tạo ViewModel ở đây để sử dụng lại
    val signInViewModel: GoogleSignInViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.SPLASH.name) {
        composable(route = Screen.SPLASH.name) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.SIGNIN.name) {
            SignInScreen(navController,viewModel = signInViewModel)
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
        composable(route = Screen.NOTIFICATION.name) {
            NotificationPerScreen(activity,navController = navController)
        }
    }
}
