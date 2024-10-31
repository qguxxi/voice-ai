package com.qguxxi.tapper.ui.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.R
import com.qguxxi.tapper.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Ui with black background and logo
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
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Screen.SIGNIN.name) {
            popUpTo(Screen.SPLASH.name) { inclusive = true } // Remove splash screen from stack
        }
    }
}
@Preview(showBackground = true, widthDp = 407, heightDp = 904)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}


