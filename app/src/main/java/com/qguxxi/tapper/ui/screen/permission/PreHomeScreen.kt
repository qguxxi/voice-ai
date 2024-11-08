package com.qguxxi.tapper.ui.screen.permission

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.tapper.R
import com.qguxxi.tapper.navigation.Screen
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.button.TextButtonGo
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography

@Composable
fun PreHomeScreen(navController: NavController) {
    Surface(
        modifier =  Modifier.fillMaxSize()
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Box(
                modifier = Modifier.size(300.dp)
            ) {
                LottieAnimation(
                    composition = composition,
                    speed = 2.5f,
                    iterations = LottieConstants.IterateForever
                )
            }
            Spacer(modifier = Modifier.weight(5f))
            Text(text = "Interact Seamlessly with AI", style = figmaTypography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Voice Activated and Ready", style = figmaTypography.labelLarge)
            Spacer(modifier = Modifier.weight(5f))
            TextButtonGo(onClick = {
                navController.navigate(Screen.HOME.name) {
                    popUpTo(Screen.PREHOME.name) {
                        inclusive = true
                    }
                }
            })
            PrivacyPolicy(
                privacyOnClick = {
                    navController.navigate(Screen.HOME.name) {
                        popUpTo(Screen.PREHOME.name) {
                            inclusive = true
                        }
                } },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.pre_home,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun PreHomePreview() {
    PreHomeScreen(navController = rememberNavController())
}