package com.qguxxi.tapper.ui.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.Image
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.R
import com.qguxxi.tapper.navigation.Screen
import com.qguxxi.tapper.untils.google.GoogleSignInViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val signInViewModel: GoogleSignInViewModel = viewModel()
    val isLoggedIn by signInViewModel.isLoggedIn.observeAsState()
    LaunchedEffect(isLoggedIn) {
        delay(1000)
        if (isLoggedIn == true) {
            navController.navigate(Screen.HOME.name) {
                popUpTo(Screen.SPLASH.name) { inclusive = true }
            }
        } else {
            navController.navigate(Screen.SIGNIN.name) {
                popUpTo(Screen.SPLASH.name) { inclusive = true }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_main), // Logo
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 407, heightDp = 904)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}


