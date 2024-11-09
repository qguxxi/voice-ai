package com.qguxxi.tapper.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.theme.TapperTypography
import com.qguxxi.tapper.ui.theme.figmaTypography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val composition1 by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))
    val composition2 by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.record))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f).padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = stringResource(id = R.string.ai_warning_1) ,
                style = figmaTypography.titleSmall ,
                modifier = Modifier.graphicsLayer(alpha = 0.6f)
            )
            Text(
                text = stringResource(id = R.string.ai_warning_2) ,
                style = figmaTypography.titleSmall ,
                modifier = Modifier.graphicsLayer(alpha = 0.6f)
            )
        }
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            LottieAnimation(
                composition = composition1,
                speed = 2.5f,
                iterations = LottieConstants.IterateForever
            )
        }
        Text(text = stringResource(id = R.string.ai), style = TapperTypography.bodyMedium)
        Spacer(modifier = Modifier.weight(3f))
        Box(
            modifier = Modifier.size(100.dp)
        ) {
            LottieAnimation(composition = composition2)
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}