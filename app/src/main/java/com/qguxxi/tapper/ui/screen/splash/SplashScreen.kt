package com.qguxxi.tapper.ui.screen.splash

import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.animation.core.Animatable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.R
import com.qguxxi.tapper.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    // Animatable properties for scale and rotation
    val scale = remember { Animatable(1f) }

    // Launching the shrinking and rotating animation, then navigate
    LaunchedEffect(Unit) {
        // Animate the icon to shrink and rotate
        launch {
            scale.animateTo(
                targetValue = 0.5f,
                animationSpec = tween(durationMillis = 1000)
            )
        }
        // Navigate to SignIn Screen
        navController.navigate(Screen.SIGNIN.name) {
            popUpTo(Screen.SPLASH.name) { inclusive = true }
        }
    }

    // UI with shrinking and rotating icon
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.logo_main),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(200.dp)
                .scale(scale.value)
        )
    }
}
@Preview(showBackground = true, widthDp = 407, heightDp = 904)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}


