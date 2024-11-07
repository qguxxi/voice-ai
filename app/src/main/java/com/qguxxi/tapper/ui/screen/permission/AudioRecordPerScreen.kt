package com.qguxxi.tapper.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.MainActivity
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography
import com.qguxxi.tapper.untils.permission.checkAndRequestAudioPermission
import com.qguxxi.tapper.untils.permission.checkAndRequestCameraPermission

@Composable
fun AudioRecordScreen(navController: NavController,activity: Activity,modifier: Modifier) {
    Surface(
        modifier =  modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.bumbel_3),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = modifier.weight(5f))
            Text(text = "Learn Quickly with AI", style = figmaTypography.bodyMedium)
            Text(text = "Improve Swiftly with Tapper", style = figmaTypography.labelLarge)
            Spacer(modifier = modifier.weight(5f))
            PermissionButton(
                permClick = { checkAndRequestAudioPermission(navController = navController, activity = activity) },
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
    AudioRecordScreen(navController = rememberNavController() , activity =  MainActivity(), modifier = Modifier)


}