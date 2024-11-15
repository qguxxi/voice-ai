package com.qguxxi.tapper.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography
import com.qguxxi.tapper.untils.permission.AudioRecordPermission

@Composable
fun AudioRecordScreen(navController: NavController,activity: Activity,modifier: Modifier) {
    Surface(
        modifier =  modifier.fillMaxSize()
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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
            Spacer(modifier = modifier.weight(5f))
            Text(text = "Interact Seamlessly with AI", style = figmaTypography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Voice Activated and Ready", style = figmaTypography.labelLarge)
            Spacer(modifier = modifier.weight(5f))
            PermissionButton(
                permClick = { AudioRecordPermission.checkAndRequestAudioPermission(navController = navController, activity = activity) },
                idIcon = R.drawable.audio_record,
                idString = R.string.audio_record,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 16.dp)
            )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.audio_per,
                modifier = modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Preview
@Composable
fun AudioScreenPreview() {

}